(set-env!
 :dependencies '[[org.bovinegenius/exploding-fish "0.3.3"]
                 [org.clojure/clojure "1.8.0"]
                 [clj-http "1.1.2"]
                 [commons-codec/commons-codec "1.8"]
                 ]
 :source-paths #{"src"}
 )

(task-options!
 pom {:project 'clj-funcamps.com-api-client
      :version "0.1.0-SNAPSHOT"
      :description "clojure client to funcamps.com API"
      :license {"The MIT License (MIT)" "http://opensource.org/licenses/mit-license.php"}})
