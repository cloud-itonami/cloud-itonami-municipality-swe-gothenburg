(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest gothenburg-has-culture-basis
  (let [sb (facts/spec-basis "gothenburg")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "gothenburg" (:culture/municipality %)) sb))
    (is (every? #(= "SWE" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "stockholm")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["gothenburg" "stockholm"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["stockholm"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "gothenburg" :dish))))
  (is (= ["gothenburg.beverage.pripps"]
         (mapv :culture/id (facts/by-kind "gothenburg" :beverage))))
  (is (empty? (facts/by-kind "gothenburg" :product)))
  (is (empty? (facts/by-kind "stockholm" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
