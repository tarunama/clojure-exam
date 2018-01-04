(defproject exam "1.0.0-SNAPSHOT"
  :description "Submission to csap"
  :url "FIXME:"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure "1.9.0"]
    [org.clojure/tools.nrepl "0.2.12"]
    [integrant "0.6.3"]
    [bidi "2.1.2"]
    [buddy "2.0.0"]
    [funcool/struct "1.1.0"]
    [ring "1.5.0"]
    [hiccup "1.0.5"]
    [org.clojure/java.jdbc "0.7.5"]
    [honeysql "0.9.1"]
    [ragtime "0.7.2"]
  ]
  :main ^:skip-aot exam.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
