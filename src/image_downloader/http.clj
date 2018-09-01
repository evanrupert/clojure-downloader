(ns image-downloader.http
  (:gen-class)
  (:require [clj-http.client :as client]))


(defn get-html
  "Gets the html for the given url"
  [url]
  (client/get url))
