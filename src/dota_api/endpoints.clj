(ns dota-api.endpoints)

(def api-root "http://api.steampowered.com/IEconDOTA2_570")
(def heroes (str api-root "/GetHeroes/v1"))
(def match-history (str api-root "/GetMatchHistory/v1"))
(def match-details (str api-root "/GetMatchDetails/v1"))
