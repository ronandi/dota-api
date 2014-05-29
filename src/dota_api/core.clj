(ns dota-api.core
  (:require [clj-http.client :as http]
            [dota-api.endpoints :as endpoints]))

(def ^:dynamic *token*)

(defn get-heroes
  [& {:keys [token] :or {token *token*}}]
  (let [request {:query-params {:key token :language "en"} :as :auto}]
    (try
      (get-in (http/get endpoints/heroes request) [:body :result :heroes]))))

(defn get-match-history
  [& {:keys [token] :or {token *token*} :as options}]
  (let [request {:query-params (assoc options :key token ) :as :auto}]
    (get-in (http/get endpoints/match-history ) [:body :result :matches])))

(defn get-match-details
  [match-id & {:keys [token] :or {token *token*} :as options}]
  (let [options (assoc options :key token :match_id match-id)]
    (get-in (http/get endpoints/match-details) [:body :result])))
