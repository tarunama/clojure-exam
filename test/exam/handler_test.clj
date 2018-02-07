(ns exam.handler-test
  (:require [clojure.test :refer :all]
            [exam.handler :refer [handler]]
            [ring.mock.request :refer [request]]))

(deftest handler-test
  []
  (testing "Valid cases"
    (is (= (handler (request :get "/articles/"))
           {:status 200 :headers {} :body "Article index"}))
    (is (= (handler (request :get "/articles/1/"))
           {:status 200 :headers {} :body "Article id is 1"}))
    (is (= (handler (request :get "/articles/1/comments/1"))
           {:status 200 :headers {} :body "Comment id is 1"})))

  (testing "Invalid cases"
    (is (= (handler (request :get "/articles"))
           nil))
    (is (= (handler (request :get "/articles/1"))
           nil))
    (is (= (handler (request :get "/articles/hoge/"))
           nil))
    (is (= (handler (request :get "/articles/1/comments/hoge"))
           nil))))
