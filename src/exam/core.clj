(ns exam.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.response :as resp]
            [integrant.core :as ig]))

;30.5 hour
(def config
  {:handler/greet {:name "Alice"}
   :adapter/jetty {:port 3002
                   :handler (ig/ref :handler/greet)}})

(defmethod ig/init-key :adapter/jetty [_ {:keys [handler] :as opts}]
  (jetty/run-jetty handler (-> opts
                               (dissoc :handler)
                               (assoc :join? false))))

(defmethod ig/init-key :handler/greet [_ {:keys [name]}]
  (fn [_] (resp/response (str "Hello " name))))

(defmethod ig/halt-key! :adapter/jetty [_ server]
  (.stop server))

(ig/init config)

