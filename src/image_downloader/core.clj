(ns image-downloader.core
  (:require [image-downloader.cli :as cli]
            [image-downloader.http :as http]
            [image-downloader.scraper :as scraper]
            [image-downloader.downloader :as downloader]))

(defn -main
  [& args]
  (let [parsed-args (cli/parse-args args)]
    (-> parsed-args
        :url
        http/get-html
        scraper/extract-links
        (downloader/download-images (:destination parsed-args)))))

