#!/usr/bin/env clj

(require '[clojure.string :as str])

(defn isnumeric [s] 
  (and
    (not (empty? s))
    (every? #(Character/isDigit %) s)))

(defn filterer2 [line]
  (def col2 (get (str/split line #" " 3) 1))
  (if (isnumeric col2)
    (> (Integer/parseInt (str/trim col2)) 10)
    false))

(defn filterer [line]
  (try 
    (> (Integer/parseInt (str/trim (get (str/split line #" " 3) 1))) 10)
    (catch Exception e false)))

(defn process [in out]
  (with-open [bufout (java.io.BufferedWriter. out) bufin (java.io.BufferedReader. in)]
    (doseq
      [l (line-seq bufin)]
      (if (filterer l) (do (.write bufout l) (.newLine bufout))))))

(defn process-file [fin fout]
  (process (java.io.FileReader. fin) (java.io.FileWriter. fout)))

(defn process-stdio [] (process *in* *out*))

; (time (process-file "test-files/data.txt" "output/clojure.out"))
;(process (java.io.StringReader. (slurp "test-files/data.txt")))
