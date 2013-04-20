(ns discrete.core)

;; from http://programming-pages.com/2012/01/16/recursion-in-clojure/
(defn power
  ([x y] (power x y 1))
  ([x y current]
  (if (= y 0)
    current
    (if (> y 0)
      (recur x (- y 1) (*' x current))
      (recur x (+ y 1) (/ current x))))))

(defn seed-planter [a current bit]
  (let [squared (*' current current)]
    (if (= bit 1)
      (*' squared a)
      squared)))

(defn to-bits [b] 
  (map #(Character/digit %1 2) (.toString (biginteger b) 2)))

; a^b through seed planting
(defn power-sp [a b]
  (let [bits-of-b (to-bits b)]
    (loop [current 1
           bits bits-of-b]
      (if (= (count bits) 0)
        current
        (recur (seed-planter a current (first bits)) (rest bits))))))

; a^b (mod n) through seed planting
(defn power-mod [a b n]
  (let [bits-of-b (to-bits b)]
    (loop [current 1
           bits bits-of-b]
      (if (= (count bits) 0)
        current
        (recur (mod (seed-planter a current (first bits)) n) (rest bits))))))


(defn dot [v1 v2]
  (reduce + (map * v1 v2)))

;; using Euclid's algorithm
(defn gcf [a b] 
  (if (= b 0) a 
      (gcf b (mod a b))))

(defn relatively-prime? [a b]
  (= (gcf a b) 1))

; The number of numbers in {1, 2, .., n} that are relatively prime to n
(defn phi [n]
  (loop [current 1 rp-count 0]
    (if (= current n)
      rp-count
      (if (relatively-prime? current n)
        (recur (inc current) (inc rp-count))
        (recur (inc current) rp-count)))))

(defn pki-e [d phi-n f]
  (/ (+ 1 (* phi-n f)) d))

(defn integer-pki-e [d phi-n]
  (loop [f 1]
    (let [e (pki-e d phi-n f)]
    (if (not (ratio? e))
      e
      (recur (inc f))))))

(defn power-mod
  ([a b n] (power-mod a b 1 n))
  ([a b current n]
    (if (= b 0)
      current
      (recur a (dec b) (mod (* a current) n) n))))

;; from http://clojure.roboloco.net/?tag=proper-divisors
(defn proper-divisors [x]
  (filter #(zero? (mod x %1)) (range 1 (+ 1 (/ x 2)))))

(defn aliquot-sum [x]
  (reduce + (proper-divisors x)))

(defn fact [x] (reduce *' (range 1 (inc x))))

(defn factorials []
  (letfn [(factorial-seq [n1 n2]
            (lazy-seq 
              (cons fact (factorial-seq (inc n1) (*' (inc n1) n2)))))]
  (factorial-seq 1 1)))

(defn sum-of-digits [x]
  (apply + (map #(Character/digit %1 10) (str x))))


(defn isbn-10 [x]
  (let [coefficients (reverse (range 1 11))
        isbn (apply str (filter #(Character/isDigit %1) (str x)))
        digits (map #(Character/digit %1 10) isbn)
        dot-product (dot coefficients digits)]
    (= (mod dot-product 11) 0)))

(defn isbn-13 [x]
  (let [coefficients (flatten (repeat [1 3]))
        isbn (apply str (filter #(Character/isDigit %1) (str x)))
        digits (map #(Character/digit %1 10) isbn)
        dot-product (dot coefficients (take 12 digits))
        modulus (mod dot-product 10)
        check-digit (last digits)]
    (= (- 10 check-digit) modulus)))



;; From https://gist.github.com/sritchie/1627900
(defn transpose [coll]
  (apply map vector coll))
 
(defn matrix-mult [mat1 mat2]
  (let [row-mult (fn [mat row] 
                   (map (partial dot row) (transpose mat)))]
    (map (partial row-mult mat2) mat1)))
