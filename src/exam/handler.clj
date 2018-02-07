(ns exam.handler
  (:require [bidi.ring :refer [make-handler]]
            [ring.util.response :as res]))

(defn articles-handler
  [request]
  (res/response "Article index"))

(defn article-handler
  [{:keys [route-params]}]
  (res/response (str "Article id is " (:id route-params))))

(defn comment-handler
  [{:keys [route-params]}]
  (res/response (str "Comment id is " (:comment_id route-params))))

(def handler
  (make-handler ["/" {"articles" {"/" articles-handler
                                  ["/" [#"\d+" :id]] {"/" article-handler
                                                      ["/comments/" [#"\d+" :comment_id]] comment-handler}}}]))
