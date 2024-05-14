package poo.classes

import java.time.LocalDate

//No Kotlin, o construtor padrão da classe e seus atributos, podem ser especificados aqui ou dentro da classe.
class Pessoa(val cpf: String, val nome: String, val nascimento: LocalDate) {
    val idade = LocalDate.now().year - nascimento.year

    fun falar(mensagem: String){
        println("$nome falou: $mensagem")
    }
}