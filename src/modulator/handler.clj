(ns modulator.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "modulator")
  (GET "/image/*" [* & params :as req]
       (str "Will process image: " *
            "<br/>With params: " params
            "<br/><br/>Ring request: " req))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
