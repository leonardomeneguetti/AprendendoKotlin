package poo.encapsulamento2

import java.math.BigDecimal
import java.time.LocalDate

class Application {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val leonardo = Pessoa("123.123.123-12", "Leonardo", LocalDate.of(2003, 12, 13))
            leonardo.email = "teste"
        }
    }
}