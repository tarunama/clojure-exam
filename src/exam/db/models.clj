(ns exam.db.models
  (:require [clojure.java.jdbc :as jdbc]))

(def article-table-ddl
  (jdbc/create-table-ddl :articles [[:id :int "not null" "primary key" "auto_increment"]
                                   [:text :text "not null"]]))

(def user-table-ddl
  (jdbc/create-table-ddl :users [[:id :int "not null" "primary key" "auto_increment"]
                                 [:name "varchar(16)" "not null"]
                                 [:password "char(32)" "not null"]]))

(def comment-table-ddl
  (jdbc/create-table-ddl :comments [[:id "int" "not null"]
                                    [:article_id :int "not null"]
                                    [:user_id :int "not null"]
                                    [:text :text "not null"]
                                    ["index art_idx (article_id)," "index user_idx (user_id)," "foreign key(article_id) references articles(id)," "foreign key(user_id) references users(id)"]]))

(def all-table-ddl
  [article-table-ddl
   user-table-ddl
   comment-table-ddl])

