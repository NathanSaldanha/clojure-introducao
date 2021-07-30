(ns estoque.aula2)

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for maior que 100."
  [valor-bruto]

  (if (> valor-bruto 100)

  		(let [taxa-de-desconto (/ 10.0 100)
  								desconto									(* valor-bruto taxa-de-desconto)]
  					(println "Calculando desconto de",desconto)
  					(- valor-bruto desconto))
  		valor-bruto))

(println
	(valor-descontado 100))