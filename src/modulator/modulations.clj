(ns modulator.modulations)

(defmulti modulate
  "Modulate an image

  Args:
      - m <map> A modulation map (see modulator.engine/parse-mods)"

  (fn [m]
    (println "Modulating with " m)
    (:name m)))


(defmethod modulate "resize"
  [m]
  (let [p (:params m)]
    (println "Resizing with params: " p)))


(defmethod modulate "format"
  [m]
  (let [p (:params m)]
    (println "Formatting with params: " p)))