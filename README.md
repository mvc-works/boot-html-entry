
boot task of html-entry
---

> ...to create html files

### Usage

[![Clojars Project](https://img.shields.io/clojars/v/mvc-works/boot-html-entry.svg)](https://clojars.org/mvc-works/boot-html-entry)

In your `build.boot`:

```clojure
(require '[html-entry.core :refer :all])

(defn html-dsl "Hiccup HTML DSL" [] [:html [:div "a demo" [:text "text"]]])

(deftask gen-html
  "Demo of HTML entry"
  []
  (html-entry :dsl (html-dsl)))
```

* `:dsl` required, for exmaple `[:div "demo"]`
* `:html-name` defaults to `"index.html"`

### License

MIT
