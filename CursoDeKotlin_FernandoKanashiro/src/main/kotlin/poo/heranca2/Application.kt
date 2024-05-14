package poo.heranca2

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
                //when faz a checagem em cascata, se "animal is mamifero" fosse a primeira condição, só passsaria por ela
                when {
                    //diferente do java, o casting no caso de herança não é necessário
                    //isso faz o mesmo que o instanceOf() do java
                    animal is Cachorro -> animal.latir()
                    animal is Gato -> animal.miar()
                    animal is Peixe -> println("É um peixe")
                    animal is Mamifero -> println("Puts, um mamífero")
                }
                //Usando esse código, você faz um casting forçado
                (animal as Gato).miar()
                //Para fazer esse casting forçado de forma segura, ou seja, sem estourar erro, use:
                (animal as? Gato)?.miar()
            }
        }
    }
}