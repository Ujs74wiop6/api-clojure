(ns crud.repository.migrations
  (:require [clojure.java.jdbc :as jdbc]
            [crud.repository.migrations :as migrations]))

(def db {:dbtype "postgresql"
         :dbname "produto" 
         :user "postgres"
         :password "postdba"})

(def produto-table-ddl
  (jdbc/create-table-ddl "items" [[:id "SERIAL PRIMAY KEY"]
                                  [:title "VARCHAR(255)"]
                                  [:description "VARCHAR(255)"]]))

(defn migrated? [table-name]
  (-> (jdbc/query db
                  [(str "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES "
                        "WHERE table_name='" table-name "'")])
      first :count pos?))

(defn run-migrations []
  (when (not (migrated? "items"))
    (print "Creating produto database...") (flush)
    (jdbc/db-do-commands db 
                        [produto-table-ddl])))

(extend-protocol clojure.java.jdbc/ISQLParameter
  clojure.lang.IPersistentVector
  (set-parameter [v ^java.sql.PreparedStatement stmt ^long i]
    (let [conn (.getConnection stmt)
          meta (.getParameterMetaData stmt)
          type-name (.getParameterTypeName meta i)]
      (if-let [elem-type (when (= (first type-name) \_) (apply str (rest type-name)))]
           (.setObject stmt i (.createArrayOf conn elem-type (to-array v)))
           (.setObject stmt i v)))))

(extend-protocol clojure.java.jdbc/IResultSetReadColumn
  java.sql.Array
  (result-set-read-column [val _ _]
    (into [] (.getArray val))))