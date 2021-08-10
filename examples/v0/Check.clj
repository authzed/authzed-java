(ns authzed-clojure-example.core
  (:gen-class)
  (:import [io.grpc ManagedChannelBuilder]
           [com.authzed.api.v0 AclService$CheckRequest ACLServiceGrpc Core$User Core$ObjectAndRelation]
           [com.authzed.grpcutil BearerToken]))

(defn authzed-aclstub
  "Initializes an Authzed stub for the ACL gRPC Service"
  [token]
  (-> (ACLServiceGrpc/newBlockingStub
       (-> (ManagedChannelBuilder/forTarget "grpc.authzed.com:443")
           (.useTransportSecurity)
           (.build)))
      (.withCallCredentials (new BearerToken token))))

(defn authzed-objrel
  "Creates an Authzed object and relation"
  [object id relation]
  (-> (Core$ObjectAndRelation/newBuilder)
      (.setNamespace object)
      (.setObjectId id)
      (.setRelation relation)
      (.build)))

(defn authzed-user
  "Creates an Authzed userset"
  [user-id]
  (-> (Core$User/newBuilder)
      (.setUserset (authzed-objrel "blog/user", user-id, "..."))
      (.build)))

(defn -main [& _args]
  (let [client (authzed-aclstub "t_your_token_here_1234567deadbeef")
        request (-> (AclService$CheckRequest/newBuilder)
                    (.setUser (authzed-user "emilia"))
                    (.setTestUserset (authzed-objrel "blog/post" "1" "read"))
                    (.build))
        response (.check client request)]
    (println (.toString response))))
