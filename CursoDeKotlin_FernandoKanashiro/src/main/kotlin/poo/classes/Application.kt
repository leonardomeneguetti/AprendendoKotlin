package poo.classes

import java.time.LocalDate

class Application {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val leonardo: Pessoa = Pessoa("123.123.123-12", "Leonardo", LocalDate.of(2003, 12, 13))
            leonardo.falar("Fala corno!")
        }
    }
}