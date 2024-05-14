package poo.heranca

import java.math.BigDecimal

class Application {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val calculadora = CalculadoraCientifica()
            calculadora.somar(BigDecimal("6"))
            calculadora.subtrair(BigDecimal("4"))
            calculadora.potencia(8)
        }
    }
}