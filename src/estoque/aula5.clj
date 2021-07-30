(ns estoque.aula5)

(def estoque { "mochila" 10, "camiseta" 5 })
(println estoque)

(println "Temos" (count estoque) "elementos")
(println "Chaves são:" (keys estoque))
(println "Chaves são:" (vals estoque))

(def estoque {:mochila 10, :camiseta 5})
(println "Usando keyword:" estoque)

(println "Retornando um novo mapa, associando uma nova key" (assoc estoque :cadeira 3))
(println "Retornando um novo map, sobrescrevendo um valor:" (assoc estoque :mochila 3))

(println estoque)
(println "Recebendo indice que quero atualizar e uma função:" (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "tirando um de" valor)
  (- valor 1))

(println "Recebendo indice que quero atualizar e uma função:" (update estoque :mochila tira-um))
(println "Tirando 3 do valor que me for passado" (update estoque :mochila #(- % 3)))

(println "Retornando um novo mapa, desassociando um key" (dissoc estoque :mochila))

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println)
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)
(println (pedido :mochila))                                 ;mapa como função
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira {}))                          ;get com valor default
(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido {}))

(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

;THREADING FIRST
(println (-> pedido
             :mochila
             :quantidade))