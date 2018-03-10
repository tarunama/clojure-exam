(ns exam.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.flash :refer [wrap-flash]]
            [exam.handler :refer [handler]]))

(defonce server (atom nil))

(defn run-server [handler]
  (when-not @server
    (reset! @server (jetty/run-jetty handler {:port 3002}))))

(defn stop-server []
  (when @server
    (.stop @server)))

(defn -main [& args]
  (-> handler
      wrap-session
      wrap-flash
      run-server))
