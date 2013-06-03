(ns modulator.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [modulator.engine :as engine]))

(defroutes app-routes
  (GET "/" [] "modulator")
  (GET "/image/*" [* & params :as req]
       (str "Will process image: " *
            "<br/>With params: " params
            "<br/><br/>Will apply: <br/>" (engine/parse-mods engine/modulation-config params)
            "<br/><br/>Ring request: " req))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
