(defproject cljsbuild-example-advanced "0.0.9"
  :description "An advanced example of how to use lein-cljsbuild"
  :source-path "src-clj"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [compojure "0.6.5"] 
                 [hiccup "0.3.7"]]
  :dev-dependencies [[lein-cljsbuild "0.0.9"]
                     [lein-ring "0.5.0"]]
  :hooks [leiningen.cljsbuild]
  :jar true
  :cljsbuild [{:source-path "src-cljs"
               :crossovers [example.crossover]
               :compiler {:output-to "resources/public/js/main-debug.js"
                          :optimizations :whitespace
                          :pretty-print true}}
              {:source-path "src-cljs"
               :crossovers [example.crossover]
               :compiler {:output-to "resources/public/js/main.js"
                          :optimizations :advanced
                          :pretty-print false}}]
  :ring {:handler example.routes/app})
