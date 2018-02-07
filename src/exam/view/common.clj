(ns exam.view.common
  (:require [hiccup.page :refer [html5]]))

(defn common
  [req & body]
  (html5
   [:head
    [:title "exam-clj"]]
   [:body
    [:main body]])
