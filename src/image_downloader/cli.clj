(ns image-downloader.cli
  (:gen-class)
  (:require [clojure.string :as str]
            [clojure.tools.cli :refer [parse-opts]]))

(def cli-specs [["-h" "--help" :default false]])

;; TODO: Check for proper number of arguments
(defn parse-args
  [args]
  (let [parsed (parse-opts args cli-specs)
        [url dest] (:arguments parsed)
        options (:options parsed)]
    {:url url :destination dest :options options}))

(def help-message
  "Usage:\n
  downloader [options] file
  Options:
    -h, --help \t\tShow this message
    -o, --output \t\tSpecify an output directory to download the files to")

(defn raise-error
  [err]
  (println err)
  (println help-message)
  (System/exit 0))

(defn validate-arguments
  [args]
  (cond
    (str/blank? (:url args)) (raise-error "Must input url to download from")
    :else args))
