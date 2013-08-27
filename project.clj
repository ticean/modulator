(defproject modulator "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://github.com/ticean/modulator"
  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler modulator.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
