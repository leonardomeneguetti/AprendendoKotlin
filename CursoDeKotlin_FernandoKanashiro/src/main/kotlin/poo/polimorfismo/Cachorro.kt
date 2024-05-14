package poo.polimorfismo

class Cachorro: Mamifero() {
    fun latir(){
        println("Au Au Au")
    }

    //para sobrescrever uma função da classe mãe, usa "override" antes de "fun"
    override fun comunicar() {
        latir()
    }
}