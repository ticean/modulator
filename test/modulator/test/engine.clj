(ns modulator.test.engine
  (:use clojure.test
        modulator.engine))

(deftest test-engine
  (testing "parse-mods"
    (let [params {:w 100 :h 100 :fit "crop" :fm "jpg" :bogus "nothing"}
          config [{:name "resize" :params [:w :h :fit :bg]}
                  {:name "format" :params [:fm]}]]

      (is (= (parse-mods config params)

             [{:name "resize", :params {:fit "crop" :h 100 :w 100}}
              {:name "format", :params {:fm "jpg"}}])))))
