(ns exam.router-test
  (:require [clojure.test :refer :all]
            [exam.router :refer [router]]
            [bidi.bidi :refer [match-route]]))


(deftest router-test
  []
  (is (= (match-route router "/articles/")
         {:handler :article-list}))
  (is (= (match-route router "/articles/1")
         {:handler :article, :route-params {:id "1"}}))
  (is (= (match-route router "/articles/1/comments/1")
         {:handler :comment, :route-params {:id "1", :comment_id "1"}}))
  (is (= (match-route router "/article/hoge") nil))
  (is (= (match-route router "/article/1/comments/hoge") nil)))
