(ns exam.db.main-test
  (:require [clojure.test :refer :all]
            [clojure.java.jdbc :as jdbc]
            [honeysql.core :as sql]
            [honeysql.helpers :refer :all :as helpers]
            [exam.db.main :refer :all]))

; HACK: write test
