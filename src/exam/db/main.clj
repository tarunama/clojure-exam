(ns exam.db.main
  (:require [clojure.java.jdbc :as jdbc]
            [exam.db.models :as models]))

; HACK: extract project.clj by environ
(def db-spec
  {:dbtype   "mysql"
   :dbname   "clj_exam"
   :host     "localhost"
   :port      3306
   :user     "clj_exam"
   :password "clj_exam"})

(defn create-table
  [table-ddl]
  (jdbc/db-do-commands db-spec table-ddl))

(defn drop-table
  [table-name]
  (jdbc/db-do-commands db-spec (jdbc/drop-table-ddl table-name)))

(defn create-all-table
  []
  (map create-table models/all-table-ddl))
