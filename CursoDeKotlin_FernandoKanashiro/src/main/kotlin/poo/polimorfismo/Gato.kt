package poo.polimorfismo

class Gato: Mamifero() {
    fun miar(){
        println("Miau Miau Miau")
    }

    override fun comunicar() {
        miar()
    }
}