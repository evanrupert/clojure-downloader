(ns image-downloader.downloader
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn download-images
  [urls destination]
  (map-indexed
    (fn [i url]
      (let [filename (create-file-name i)
            file-path (path-combine destination filename)]
        (download url filepath)))
    urls))

(defn- download
  [url destination]
  (with-open [in (io.input-stream url)
              out (io/output-stream destination)]
    (io/copy in out)))

(defn- create-file-name
  [num]
  (str "img" num ".jpg"))

(defn path-combine [s1 s2]
  (cond
    (string/starts-with? s2 "/") 
      s2
    (not (string/ends-with? s1 "/"))
      (-> (string/split s1 #"[\\/]")
          butlast
          (#(string/join "/" %))
          (str , "/")
          (path-combine , s2)) 
    :else  
      (-> (string/join "/" [s1 s2])
          (string/replace ,  #"[\\/]+" "/")))) 