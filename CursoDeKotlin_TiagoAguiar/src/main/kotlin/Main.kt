//Antações feitas assistindo as aulas do Tiago Aguiar: https://www.youtube.com/@TiagoAguiar
fun main() {
    //var = variável imutavel
    var products = "teu pai"

    //val = variável imutável(constante)
    val product: String = "iMac"
    //o kotlin entende o tipo autmaticamente, mas, variavel: tipo estipula o tipo - boa prática
    val age: Int = 20
    val price: Double = 400.20

    //println mostra no terminal
    println(product::class)
    //variavel::class pega a classe da variavel, parecido com instanceOf()
    println(age::class)
    println(price::class)

    //Tipos primitivos
    //Inteiros
    val byte: Byte = 127 //8 bit (1 Byte)
    val short: Short = 32767 //16 bit
    val int: Int = 2147483647 //32 bit
    val long: Long = 9223372036854775807 //64 bit
    //Pode colocar "_" entre as divisões de milhar (9223372036854775807 == 9_223_372_036_854_775_807)

    //Decimais
    val float: Float //32 bit
    val double: Double //64 bit

    //Texto
    val string: String = "Oi" //Sequencia de char - aspas dupals ("")
    val char: Char = 'T' //Caractere - aspas simples ('')

    //Boolean
    val boolean: Boolean = true //1 Byte

    //Conversão de tipo
    //Int pra Duble
    val preco: Int = 22
    println(preco.toDouble())

    //Double pra Int
    val idade: Double = 22.1
    println(idade.toInt())

    //Caracteres especiais (não são mostrados durante um println() e tem funções específicas
    //"\n" = pula linha
    //"\t" = dar um tab

    val name = "alakazam"
    println(name.length) //string.length no Kotlin não é uma função, mas sim uma propriedade da classe String
    println(name.uppercase()) //string.uppercase() e string.lowercase() são funções da classe String

    //Formatação de texto
    //1. Caaracteres especiais
    var msg: String = "Olá Leonardo, \nSeu produto chegou"
    println(msg)

    //2. Aspas triplas
    msg = """
        Olá Leonardo,
        Seu produto chegou
    """.trimIndent() //formata o texto, ignorando as indentações
    println(msg)

    //3. Variáveis no meio
    val nome = "Leonardo"
    val sobrenome = " Meneguetti"
    val produt = "PlayStatio 5"
    println("Olá ${nome+sobrenome}, seu $produt chegou") //== println("Olá " + (nome + sobrenome) + ", seu " + produto + " chegou")

    //Conddições
    val produts = "iPhone"

    //Expressões booleanas (<, <=, =, >=, >, !, !=, ==, &&, ||)
    //No Kotlin, para comparar strings é apenas necessário "string1 == string2", ao invés de usar "string1.equals(string2)"
    if(produts.length == 0){
        println("Não pode nome vazio")
    } else if(produts.length < 3) {
        println("Não pode cadastrar produto com nome pequeno")
    } else {
        println("Produto cadastrado")
    }

    //Tratando Null
    //No Kotlin, se apenas declararmos uma variavel normalmente, essa variável não pode receber o valor null
    //Para que uma variável possa receber o null, temos que declarar isso explicitamente
    //var nomeNaoNull: String = null //da erro pois não aceita null
    var nomeNull: String? = null //o "?" na frente do tipo declara ela como podendo ser null

    //Essa condição faz com que apenas quando não for null, a instrução seja realizada
    if(nomeNull != null) {
        val qtdCaracteres = nomeNull.length
        println(qtdCaracteres)
    }
    //Mas ela pode ser substituida por essa, que verifica se é null logo antes de chamar a função/propriedade
    val qtdCaracteres = nomeNull?.length ?: 0 //o "?:"(Operador Elvis) especifica um valor padrão caso a variável seja null
    println(qtdCaracteres)

    olaMundo()

    println(soma())
}

//Funções sem retorno em Kotlin funcionam exatamente como em java, mas com "fun" no começo e sem "void" antes do nome
fun olaMundo() {
    println("Olá mundo")
}

//Em funções com retorno, o tipo deve ser especificado depois do nome "fun nomeFunção(): Tipo {}"
fun soma(): Int {
    return 2 + 3
}