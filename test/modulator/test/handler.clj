(ns modulator.test.handler
  (:use clojure.test
        ring.mock.request
        modulator.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "modulator"))))

  (testing "image route"
    (let [response (app (request :get "/image/http://google.com/image.jpg"))]
      (is (= (:status response) 200))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
