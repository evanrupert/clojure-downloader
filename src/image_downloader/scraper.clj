(ns image-downloader.scraper
  (:gen-class))


(defn extract-links
  [html]
  (re-seq  #"<img src=\"([^\"]*)\"" html))

(defn extract-links
  [html]
  (->> html
      (re-seq #"<img src=\"([^\"]*)\"")
      (map second)))
