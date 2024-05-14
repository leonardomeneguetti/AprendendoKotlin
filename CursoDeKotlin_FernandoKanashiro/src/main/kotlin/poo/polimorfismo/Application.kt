package poo.polimorfismo

import java.math.BigDecimal
import java.time.LocalDate

class Application {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val leonardo = Pessoa("123.123.123-12", "Leonardo", LocalDate.of(2003,12,13))
            leonardo.adotar(Gato())
            leonardo.adotar(Cachorro())
            leonardo.adotar(Peixe())

            for(animal in leonardo.animaisAdotados){
                animal.comunicar()
            }
        }
    }
}