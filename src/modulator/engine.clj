(ns modulator.engine)

;; Define all the available image modulations
;(def mods [{:name "resize" :params [:w :h :fit :bg]}])
(def modulation-config [{:name "resize" :params [:w :h :fit :bg]}
                        {:name "format" :params [:fm]}])


(defn parse-mods
  "Parses the modulations to be applied as required from a map of params.
  Done in this way because users may request multiple modulations in a single
  request and many of the modulations accept several parameters. This will group
  modulations with their associated parameters.

  At this time, mods are not returned in any particular order
  but sorting can be easily added to the modulations config.

  Args:

    - modulations - <vec> A vector of maps containing the available modulations
    - params      - <map> A map of API parameters

  Returns:
  A vector of modulation hashes in the form of:

      [{ :name mod1 :params { :p1 v1 :p2 v2 ... } }
       ...]"

  [modulations params]
  (reduce (fn [results, m]
            (let [p (select-keys params (:params m))]
              (if (empty? p)
                results
                (conj results {:name (:name m)
                               :params p}))))
          []
          modulations))

