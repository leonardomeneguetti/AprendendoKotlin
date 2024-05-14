package poo.encapsulamento2

import java.time.LocalDate

//No Kotlin, o construtor padrão da classe e seus atributos, podem ser especificados aqui ou dentro da classe.
class Pessoa(val cpf: String, val nome: String, val nascimento: LocalDate) {
    //Pelas variáveis serem val, já não existe a preocupação de mudar o valor dela, ent n precisa de um get
    val idade = LocalDate.now().year - nascimento.year
    //E quando a variável é var, já existe a noção de que ela vai ser alerada mesmo, ent o set não faz sentido
    var email = ""
        //No Kotlin, gets e sets são criados automaticamente, mas caso queira alterar a função, use assim
        set(value){
            //regex para validação de e-mail
            if(!Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$").matches(value)){
                throw Exception("E-mail inválido.")
            }
            field = value
        }
    fun falar(mensagem: String){
        println("$nome falou: $mensagem")
    }
}