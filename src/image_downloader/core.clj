(ns image-downloader.core)

(require '[image-downloader.cli :as cli])

(defn -main
  [& args]
  (println (apply str args)))

