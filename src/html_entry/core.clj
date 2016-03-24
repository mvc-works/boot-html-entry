
(ns html-entry.core
  (:require [hiccup.core :refer [html]]
            [boot.core :as boot]
            [clojure.java.io :as io]))

(boot/deftask html-entry
  "task to generate HTML"
  [d dsl VAL edn "Hiccup style HTML DSL"]
  (let []
    (fn [next-task]
      (fn [fileset]
        (let [tmp (boot/tmp-dir!)
              out (io/file tmp "index.html")]
          (boot/empty-dir! tmp)
          (with-open [wrtr (io/writer (.getPath out))]
            (.write wrtr (html dsl)))
          (next-task (-> fileset (boot/add-resource tmp) boot/commit!)))))))
