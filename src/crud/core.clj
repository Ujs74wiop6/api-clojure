(ns crud.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [crud.controller.produto :as produtoController]
            [crud.repository.migrations :as migrations]))

(defn home-page []
  "<h1>Server: ON</h1>")

(defroutes routes
  (GET "/" [] (home-page))
  produtoController/routes
  (not-found {:error "Not found"}))

(def app
  (-> routes
      (wrap-json-body {:keywords? true :bigdecimals? true})
      wrap-json-response))

(defn -main
  []
  (migrations/run-migrations)
  (run-jetty app {:port 3000}))
