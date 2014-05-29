(ns dota-api.core-test
  (:require [clojure.test :refer :all]
            [dota-api.core :refer :all]
            [environ.core :refer [env]]))

(def api-key (env :steam-api-test-key))

(deftest get-heroes-test
  (testing "Get heroes"
      (let [heroes (get-heroes :token api-key)]
        (is (> 100 (count heroes))))))
