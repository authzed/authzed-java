(ns v1.app
  (:import
   [com.authzed.api.v1
    Core$ZedToken
    Core$Relationship
    Core$ObjectReference
    Core$SubjectReference
    Core$Relationship
    Core$RelationshipUpdate
    Core$RelationshipUpdate$Operation
    SchemaServiceOuterClass$ReadSchemaRequest
    SchemaServiceOuterClass$WriteSchemaRequest
    SchemaServiceGrpc
    SchemaServiceGrpc$SchemaServiceBlockingStub
    PermissionsServiceGrpc
    PermissionService$WriteRelationshipsRequest
    PermissionService$WriteRelationshipsResponse
    PermissionsServiceGrpc$PermissionsServiceBlockingStub
    PermissionService$CheckPermissionRequest
    PermissionService$Consistency]
   [com.authzed.grpcutil BearerToken]
   [io.grpc ManagedChannelBuilder]
   [java.util.concurrent TimeUnit])
  (:gen-class))

;; Assuming `deps.ed` have authzed dependecy in like so:
;; com.authzed.api/authzed {:mvn/version "0.1.0"}

(set! *warn-on-reflection* true)

(defn bearer-token
  ^BearerToken
  [token-str]
  (BearerToken. token-str))

(defn zed-token
  ^Core$ZedToken
  [token-val]
  (-> (Core$ZedToken/newBuilder)
      (.setToken token-val)
      (.build)))

(defn channel
  ^io.grpc.ManagedChannel
  [target]
  (-> (ManagedChannelBuilder/forTarget target)
      (.useTransportSecurity)
      (.build)))

(defn close-channel [^io.grpc.ManagedChannel channel]
  (prn "Closing channel")
  (-> channel
      (.shutdownNow)
      (.awaitTermination 5 TimeUnit/SECONDS)))

(defn schema-service [channel bearer-token]
  (-> (SchemaServiceGrpc/newBlockingStub channel)
      (.withCallCredentials bearer-token)))

(defn permission-service [channel bearer-token]
  (-> (PermissionsServiceGrpc/newBlockingStub channel)
      (.withCallCredentials bearer-token)))

(defn write-schema!
  [^SchemaServiceGrpc$SchemaServiceBlockingStub service schema]
  (prn ::write-schema.start)
  (let [req (-> (SchemaServiceOuterClass$WriteSchemaRequest/newBuilder)
                (.setSchema schema)
                (.build))
        res (try
              (-> service
                  (.writeSchema req)
                  (.toString))
              (catch Exception e
                (prn ::write-schema.error (ex-message e))
                ""))]
    (prn ::write-schema.response res)
    res))

(defn read-schema!
  [^SchemaServiceGrpc$SchemaServiceBlockingStub service]
  (prn ::read-schema.start)
  (let [req (-> (SchemaServiceOuterClass$ReadSchemaRequest/newBuilder)
                (.build))
        res (try
              (-> service
                  (.readSchema req)
                  (.toString))
              (catch Exception e
                (prn ::read-chema.error (ex-message e))
                ""))]
    (prn ::read-schema.response res)
    res))

(defn object
  ^Core$ObjectReference
  [{:keys [definition id]}]
  (-> (Core$ObjectReference/newBuilder)
      (.setObjectType definition)
      (.setObjectId id)
      (.build)))

(defn subject
  ^Core$SubjectReference
  [subj]
  (-> (Core$SubjectReference/newBuilder)
      (.setObject (object subj))
      (.build)))

(defn relationship
  ^Core$Relationship
  [[obj rel subj]]
  (-> (Core$Relationship/newBuilder)
      (.setResource (object obj))
      (.setRelation rel)
      (.setSubject (subject subj))
      (.build)))

(def relationship-operations
  {:create Core$RelationshipUpdate$Operation/OPERATION_CREATE
   :touch Core$RelationshipUpdate$Operation/OPERATION_TOUCH
   :delete Core$RelationshipUpdate$Operation/OPERATION_DELETE})

(defn relationship-action
  ^Core$RelationshipUpdate
  [op rel]
  (-> (Core$RelationshipUpdate/newBuilder)
      (.setOperation (get relationship-operations op))
      (.setRelationship (relationship rel))
      (.build)))

(defn write-relationship!
  ^PermissionService$WriteRelationshipsRequest
  [^PermissionsServiceGrpc$PermissionsServiceBlockingStub
   service
   rel]
  (let [req (-> (PermissionService$WriteRelationshipsRequest/newBuilder)
                (.addUpdates (relationship-action :create rel))
                (.build))
        ^PermissionService$WriteRelationshipsResponse
        res
        (try
          (.writeRelationships service req)
          (catch Exception e
            (prn ::write-relationship.error (ex-message e) e)
            ""))]
    (prn ::write-relationship.success (.toString res))
    (if (string? res)
      res
      (-> res
          (.getWrittenAt)
          (.getToken)))))

(defn consistency
  ^PermissionService$Consistency
  [^Core$ZedToken zed-token]
  (-> (PermissionService$Consistency/newBuilder)
      (.setAtLeastAsFresh zed-token)
      (.build)))

(defn check-relationship!
  [^PermissionsServiceGrpc$PermissionsServiceBlockingStub
   service
   ^Core$ZedToken zed-token
   [obj rel subj]]
  (let [req
        (-> (PermissionService$CheckPermissionRequest/newBuilder)
            (.setConsistency (consistency zed-token))
            (.setResource (object obj))
            (.setSubject (subject subj))
            (.setPermission rel)
            (.build))
        res (try
              (-> service
                  (.checkPermission req)
                  (.toString))
              (catch Exception e
                (prn ::check-relationship.error (ex-message e) e)
                ""))]
    (prn ::check-relationship.success res)
    res))

(defn -main [& _]
  (let [target "grpc.authzed.com:443"
        bearer-token (bearer-token "tc_developer_def_XXX")
        schema "definition thelargeapp/article {
                  relation author: thelargeapp/user
                  relation commenter: thelargeapp/user

                  permission can_comment = commenter + author
                }

                definition thelargeapp/user {} "
        channel (channel target)
        schema-service (schema-service channel bearer-token)
        permission-service (permission-service channel bearer-token)
        test-relation [{:definition "thelargeapp/post" :id "3"}
                       "author"
                       {:definition "thelargeapp/user" :id "alice"}]]
    (try
      (write-schema! schema-service schema)
      (read-schema! schema-service)
      (check-relationship! permission-service
                           (zed-token (write-relationship! permission-service test-relation))
                           test-relation)
      (finally (close-channel channel)))))
