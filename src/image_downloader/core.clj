(ns image-downloader.core)

(defn parse-aruments
  [args]
  )

(defn -main
  [& args]
  (let [[first second] args]
    (do
      (println (str "Argument 0: " first))
      (println (str "Argument 1: " second)))))


