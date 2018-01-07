(ns exam.core
  (:require [ring.adapter.jetty :as jetty]))

(defn handler
  [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World"})

(defn run-server
  [port]
  (jetty/run-jetty handler {:port port}))

(defn -main
  [& args]
  (run-server 3000))
