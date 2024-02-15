(defproject crud "0.1.0-SNAPSHOT"
  :description "FIXME: Simple CRUD project using Clojure"
  :url "http://localhost:3000"
  :license {:name "GPL-3.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.html"}
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