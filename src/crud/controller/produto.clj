(ns crud.controller.produto
  (:require [crud.repository.produto :as produto]
            [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [compojure.coercions :refer [as-int]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

; Rotas

(defn get-all-produtos [] (produto/getAllProdutos))
(defn get-produto [id] (produto/getProduto id))
(defn create-produto! [request]
  (let [json-body (:body request)]
    (response (produto/createProduto (:title json-body) (:description json-body)))))
(defn update-produto! [id {:keys [title description]}] (produto/updateProduto id title description))
(defn delete-produto! [id] (produto/deleteProduto id))

; Buscar todos
(defroutes routes
  (GET "/produto" []
    (response
     (get-all-produtos)))

; Buscar por id  
  (GET "/produto/:id{[0-9]+}" [id :<< as-int]
    (response
     (get-produto id)))

; Criar um produto novo  
  (POST "/produto" request
    (response
     (create-produto! request)))

; Atualizando um produto
  (PUT "/produto/:produtoId{[0-9]+}" [produtoId :<< as-int :as request]
    (response
     (update-produto! produtoId (:body request))))


; Delete um produto  
  (DELETE "/produto/:id{[0-9]+}" [id :<< as-int]
    (response
     (delete-produto! id))))

(def app
  (-> routes
      wrap-json-response))