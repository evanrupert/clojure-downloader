(ns image-downloader.cli
  (:gen-class))

(require '[clojure.tools.cli :refer [parse-opts]])

(def cli-specs [["-h" "--help" :default false]])

(def parse-args
  [cmd & args]
  (let [parsed (parse-opts args cli-specs)
        opts (:options parsed)
        arguments (:arguments parsed)]
    [cmd
      (reduce (fn [acc [key val]]
                (if val
                  key
                  acc))
      nil
      opts)
    arguments]))


(def help-message
  "Usage:\n
  downloader [options] file
  Options:
    -h, --help \t\tShow this message
    -o, --output \t\tSpecify an output directory to download the files to") ;; TODO: Finish implementation

