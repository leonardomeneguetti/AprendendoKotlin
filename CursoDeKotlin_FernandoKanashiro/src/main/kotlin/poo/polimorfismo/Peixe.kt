package poo.polimorfismo

class Peixe: Animal() {
    fun borbulhar(){
        println("Glub Glub Glub")
    }

    override fun comunicar() {
        borbulhar()
    }
}