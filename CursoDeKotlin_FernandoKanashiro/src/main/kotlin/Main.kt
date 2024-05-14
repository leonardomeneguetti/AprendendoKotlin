import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date
import kotlin.random.Random
import kotlin.system.measureNanoTime

fun main(){
    //Apenas irei anotar o que não foi trabalhado no curso do outro professor

    //Tipo de dados
    //Decimais
    val bigDecimal: BigDecimal = BigDecimal("2") //É muito mais preciso que os utros tipos decimais

    //Arrays
    var array: Array<Int> = arrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20) //Conjunto de dados do mesmo tipo

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Operações
    //Em operações com Array, comparar arrays com "==" ou "!=" não da certo
    val array1: Array<Int> = arrayOf(1, 2, 3)
    val array2: Array<Int> = arrayOf(1, 2, 3)
    println(array1 == array2)
    //então se usa .contentEquals()
    println(array1.contentEquals(array2))

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Condições
    //When - Substitui IFs encadeados
    val tipoRota = "A_PE" //A_PE, CARRO, ONIBUS, TREM
    when(tipoRota) {
        "A_PE" -> println("Rota a pé")
        "CARRO" -> println("Rota de carro")
        "ONIBUS" -> println("Rota de ônibus")
        "TREM" -> println("Rota de trem")
        else -> println("Rota não implementada")
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Loops
    //For
    var soma = 0
    for(nmr in array) {
        soma += nmr
    }
    println(soma)

    //While
    var cont = 0
    soma = 0
    while (cont < array.size) {
        soma += array[cont]
        cont++
    }
    println(soma)

    //doWhile
    soma = 0
    cont = 0
    do {
        soma += array[cont]
        cont++
    } while (cont < array.size)
    println(soma)

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Funções importantes do Kotlin - Ctrl + M1 na chamada da função te leva para uma pagina de explicação dela
    //Strings
    val nome = "Leonardo Meneguetti"
    println(nome)
    //Retrona o tamanho da String
    println(nome.count())
    //Separa a String pelo regex e retorna uma lista de Strings ("" para separar cada caractere)
    println(nome.split(" "))
    //Remove os n ultimos caracteres da String
    println(nome.dropLast(4))
    //Remove os n primeiros caracteres da String
    println(nome.drop(4))
    //Retorna true se o Char especifico estiver na String
    println(nome.contains('d'))

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Array
    println(arrayToString(array))
    //Faz a soma dos elementos no array
    println(array.sumOf { it })
    //Inverte a ordem dos elementos do array
    println(arrayToString(array.reversedArray()))
    //Coloca os elemntos do array em ordem crescente
    println(arrayToString(array.sortedArray()))

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //BigDecimal
    println(bigDecimal)
    //Eleva o BigDecimal a potencia n
    println(bigDecimal.pow(3))
    //Divide o BigDecimal pelo val, especifica a qtd de casas no scale e aproxima pra cima
    println(bigDecimal.divide(BigDecimal("3"), 8, RoundingMode.HALF_UP))

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //List
    //Os Arrays não são listas mutáveis, ou seja, para adicionar um elemento novo, precisamos concatenar dois arrays
    for (num in array) println(num)
    array += arrayOf(7)
    for (num in array) println(num)
    //Existe no Kotlin o tipo List, mas este também não é dinâmico

    //Para criar listas dinamicas, utilizamos as ArrayLists ou MutableLists
    val arrayList = arrayListOf(1,2,3,4)
    for(num in arrayList) println(num)
    arrayList.add(5)
    for(num in arrayList) println(num)
    arrayList.remove(2)
    for(num in arrayList) println(num)

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Set
    //Lista que não permite dados repetidos/duplicados

    val hashSet = hashSetOf<Int>(1, 2, 4, 5) //Mais rápido, mas não garante a ordenação
    val sortedSet = sortedSetOf<Int>(1, 2, 4, 5) //Mais lento, mas faz a ordenação, que pode ser especificada por meio de Comparators
    val linkedSet = linkedSetOf<Int>(1, 2, 4, 5) //A ordenação é pela ordem de entrada dos elementos

    //Adicionando elemento que não existe em cada tipo de set
    hashSet.add(5)
    sortedSet.add(5)
    linkedSet.add(5)
    printAllElements(hashSet)
    printAllElements(sortedSet)
    printAllElements(linkedSet)

    //Adicionando elemento que ja existe em cada tipo de set
    hashSet.add(3)
    sortedSet.add(3)
    linkedSet.add(3)
    printAllElements(hashSet)
    printAllElements(sortedSet)
    printAllElements(linkedSet)

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Map
    //Estrutura chave-valor
    //Usando "mapOf(chave to valor)" cria um map não mutável
    val map =  mapOf<Int, String>(
        1 to "Muito ruim",
        2 to "Ruim",
        3 to "Regular",
        4 to "Bom",
        5 to "Muito bom"
    ) //Se forem especificados vários valores para uma mesma chave, só o ultimo será guardado

    //Usando "mutableMapOf(chave to valor)" cria um map mutável
    val mutableMap = mutableMapOf(
        1 to "Muito ruim",
        2 to "Ruim",
        3 to "Regular",
        4 to "Bom"
    )

    //Para acrescentar chaves e valores em um mutable map, existem essas duas formas
    mutableMap.put(5, "Muito bom")
    mutableMap[5] = "Muito bom"

    println(map.get(3)) //Para aacessar um valor, se usa "map.get(chave)", não é mais por índice. Retorna null se a chave não existir
    println(mutableMap[1]) //Tem a mesma função do get, também não é pelo índice

    //Criando um array de 100000 numeros aleatórios de 1 a 5
    val listaDeCodigos = Array(100000) { Random.nextInt(1, 6) }

    //criando um map com as categorias, mas agora utilizando Pair para fazer a aligação chave-valor
    val listMap = listOf(
        Pair(1, "Muito ruim"),
        Pair(2, "Ruim"),
        Pair(3, "Regular"),
        Pair(4, "Bom"),
        Pair(5, "Muito bom")
    )

    //Função que mede o tempo que a função demora para terminar
    val time1 = measureNanoTime {
        //For que acha a categoria de cada um dos numeros do array, mas isso gera um for dentro de for, que diminui a performance do código
        for(codigo in listaDeCodigos){
            val categoria = listMap.find { it.first == codigo }
        }
    }

    //Uma maneira mais rápida de se fazer é:
    val time2 = measureNanoTime {
        for(codigo in listaDeCodigos){
            val categoria = map[codigo]
        }
    }

    println(time1)
    println(time2)

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    //Date
    val date = Date() //Versão mais antiga o tipo data
    val localDate = LocalDate.now() //Versões mais novas, que trazem facilidades que a Date não tem
    val localDateTime = LocalDateTime.now() //Tem horas, minutos e segundos

    //Parse de string para tipo data
    //Date
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    var yesterdayDate = simpleDateFormat.parse("12/05/2024")
    //LocalDate
    var yesterdayLocalDate = LocalDate.from(DateTimeFormatter.ofPattern("dd/MM/yyyy").parse("12/05/2024"))
    //LocalDateTime
    var yesterdayLocalDateTime = LocalDateTime.from(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").parse("12/05/2024 16:00"))

    println(yesterdayDate)
    println(yesterdayLocalDate)
    println(yesterdayLocalDateTime)

    //Parse de tipo data para String
    //Date
    val simpleDateFormat2 = SimpleDateFormat("yyyyMMdd")
    println(simpleDateFormat2.format(yesterdayDate))
    //LocalDate
    println(DateTimeFormatter.ofPattern("yyyyMMdd").format(yesterdayLocalDate))
    //LocalDateTime
    println(DateTimeFormatter.ofPattern("yyyyMMddHHmm").format(yesterdayLocalDateTime))

    //Operações com tipo data
    //Soma e Subtração
    //Date
    yesterdayDate = Date(yesterdayDate.toInstant().plus(3, ChronoUnit.DAYS).toEpochMilli())
    println(yesterdayDate)
    //LocalDate
    println(yesterdayLocalDate.plusDays(3))
    //LocalDateTime
    println(yesterdayLocalDateTime.plusDays(4))

    //Comparar datas
    //Date
    println(yesterdayDate.after(date))
    println(yesterdayDate.before(date))
    println(yesterdayDate.equals(date))
    //LocalDate
    println(yesterdayLocalDate.isAfter(yesterdayLocalDateTime.toLocalDate()))
    println(yesterdayLocalDate.isEqual(yesterdayLocalDateTime.toLocalDate()))
    println(yesterdayLocalDate.isBefore(yesterdayLocalDateTime.toLocalDate()))
    println(yesterdayLocalDate.compareTo(yesterdayLocalDateTime.toLocalDate()))
    //LocalDateTime
    println(yesterdayLocalDateTime.isAfter(yesterdayLocalDate.atStartOfDay()))
    println(yesterdayLocalDateTime.isEqual(yesterdayLocalDate.atStartOfDay()))
    println(yesterdayLocalDateTime.isBefore(yesterdayLocalDate.atStartOfDay()))
    println(yesterdayLocalDateTime.compareTo(yesterdayLocalDate.atStartOfDay()))

    //Comparar dia da semana
    //Date
    val calendar = Calendar.getInstance()
    calendar.time = yesterdayDate
    println(calendar.get(Calendar.DAY_OF_WEEK) == 6)
    //LocalDate
    println(yesterdayLocalDate.dayOfWeek == DayOfWeek.FRIDAY)
    //LocalDateTime
    println(yesterdayLocalDateTime.dayOfWeek == DayOfWeek.SUNDAY)
}

//Função que une todos os elementos do set ou lista em uma String, separados por um separador
fun printAllElements(set: Set<Int>){
    println(set.joinToString(", "))
}

//Essa função faz com que seja mostrado os elementos do array quando usado o println()
fun arrayToString(array: Array<Int>) = array.fold("") { acc, i ->  "$acc $i" }
