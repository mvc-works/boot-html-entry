
(set-env!
  :resource-paths #{"src/"}

  :dependencies '[[org.clojure/clojure  "1.8.0"   :scope "provided"]
                  [boot/core            "2.3.0"   :scope "provided"]
                  [hiccup               "1.0.5"   :scope "provided"]])

(require '[html-entry.core :refer :all])

(def +version+ "0.1.0")

(task-options!
  pom {:project     'mvc-works/boot-html-entry
       :version     +version+
       :description "Boot task to create html entry file"
       :url         "https://github.com/mvc-works/boot-html-entry"
       :scm         {:url "https://github.com/mvc-works/boot-html-entry"}
       :license     {"MIT" "http://opensource.org/licenses/mit-license.php"}})

(task-options! push {:repo "clojars"})

(defn html-dsl "Hiccup HTML DSL" [] [:html [:div "a demo" [:text "text"]]])

(deftask gen-html
  "Demo of HTML entry"
  []
  (html-entry :dsl (html-dsl)))

(deftask build
  "Create a standalone jar file that computes fibonacci sequences."
  []
  (comp (aot) (pom) (uber) (jar)))
