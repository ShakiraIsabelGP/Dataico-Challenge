(ns probl_1)

(def invoice (clojure.edn/read-string (slurp "src/invoice.edn")))


(defn problema1 [invoice]
  (->> (get invoice :invoice/items)
       (filter (fn [item]
                 (not (and (item :taxable/taxes) (item :retentionable/retentions)))))
       (filter (fn [lazseq]
                 (or (= 19 (get (first (get lazseq :taxable/taxes)) :tax/rate))
                     (= 1 (get (first (get lazseq :retentionable/retentions)) :retention/rate)))))))
(print (problema1 invoice))