package poo.heranca2

import java.time.LocalDate

class Pessoa(val cpf: String, val nome: String, val nascimento: LocalDate) {
    //Criando uma lista de animais, a lista pode receber cachorro, gato e peixe
    val animaisAdotados = mutableListOf<Animal>()
    val idade = LocalDate.now().year - nascimento.year
    var email = ""
        set(value){
            if(!Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$").matches(value)){
                throw Exception("E-mail inválido.")
            }
            field = value
        }
    fun falar(mensagem: String){
        println("$nome falou: $mensagem")
    }

    fun adotar(animal: Animal){
        animaisAdotados.add(animal)
    }
}
