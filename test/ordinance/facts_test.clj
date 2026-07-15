(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest gothenburg-has-spec-basis
  (let [sb (facts/spec-basis "gothenburg")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://goteborg.se/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "stockholm")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["gothenburg" "stockholm"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["stockholm"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["gothenburg.lokala-ordningsforeskrifter"]
         (mapv :ordinance/id (facts/by-topic "gothenburg" :public-order))))
  (is (empty? (facts/by-topic "gothenburg" :labor)))
  (is (empty? (facts/by-topic "stockholm" :urban-planning))))
