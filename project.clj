(defproject crud "0.1.0-SNAPSHOT"
  :description "FIXME: Simple CRUD project using Clojure"
  :url "http://localhost:3000"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.7.1"]
                 [cheshire "5.10.0"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-json "0.5.0"]
                 [compojure "1.6.1"]
                 [org.clojure/java.jdbc "0.7.11"]
                 [org.postgresql/postgresql "42.3.3"]]
  :repl-options {:init-ns crud.core}
  :main crud.core)