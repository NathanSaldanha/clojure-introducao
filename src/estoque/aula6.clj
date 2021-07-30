(ns estoque.aula6)

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-15 [valor]
  (println "valor" valor)
  15)

(println (map imprime-15 pedido))
(println)

(defn imprime-15 [[chave valor]]
  (println chave "e" valor)
  15)

(println (map imprime-15 pedido))
(println)

(defn imprime-15 [[chave valor]]
  (println chave "e" valor)
  valor)

(println (map imprime-15 pedido))
(println)

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))
 (println)

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))
(println)

;THREAD LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
      (map preco-dos-produtos)
      (reduce +)))

(println (total-do-pedido pedido))
(println)

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println (total-do-pedido pedido))
(println)

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  (<=(get item :preco 0) 0))

(println (filter gratuito? (vals pedido)))
(println)

(defn gratuito?
  [[chave item]]
  (<=(get item :preco 0) 0))
(println "Itens gratuitos")
(println (filter gratuito? pedido))
(println)

(defn gratuito?
  [[_ item]]
  (<=(get item :preco 0) 0))
(println "Itens gratuitos")
(println (filter gratuito? pedido))
(println)

(defn gratuito?
  [item]
  (<=(get item :preco 0) 0))

(println "Itens gratuitos")
(println (filter (fn [[chave item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))
(println)

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(println ((comp not gratuito?) {:preco 50}))
(println ((comp not gratuito?) {:preco 0}))

(def pago? (comp not gratuito?))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))
























