package poo.encapsulamento1

import java.math.BigDecimal

class Application {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val calculadora = Calculadora()
            calculadora.somar(BigDecimal("6"))
            calculadora.subtrair(BigDecimal("5"))
            calculadora.multiplicar(BigDecimal("3"))
            calculadora.dividir(BigDecimal.TWO)
        }
    }
}