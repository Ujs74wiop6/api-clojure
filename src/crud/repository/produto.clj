(ns crud.repository.produto
  (:require [clojure.java.jdbc :as sql]
            [crud.repository.migrations :refer [db]]))

; Operações no Banco de Dados

(defn createProduto [title description]
  (sql/insert! db :items {:title title :description description}))

(defn getAllProdutos []
  (into []
        (sql/query db ["SELECT * FROM items ORDER BY id DESC LIMIT 1000"])))

(defn getProduto [id]
  (first
   (sql/query db ["SELECT * FROM items WHERE id = ?" id])))

(defn updateProduto [id title description]
  (sql/update! db :items {:title title :description description} ["id = ?" id]))

(defn deleteProduto [id]
  (sql/delete! db :items ["id = ?" id]))
