(ns exam.db.main
    (:require [clojure.java.jdbc :as jdbc]))

; HACK: extract project.clj by environ
(def db-spec
    {:dbtype "mysql"
     :dbname "clj_exam"
     :host "localhost"
     :port 3306
     :user "clj_exam"
     :password "clj_exam"})

(def fruit-table-ddl
    (jdbc/create-table-ddl :fruit [[:cost :int]
                                   [:grade :real]]))

(defn create-table []
    (jdbc/db-do-commands db-spec [fruit-table-ddl]))

(defn drop-table
    [table-name]
    (jdbc/db-do-commands db-spec (drop-table-ddl table-name)))
