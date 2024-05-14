package poo.encapsulamento1

import java.math.BigDecimal
import java.math.RoundingMode

class Calculadora {
    /*
    Modificadores de acesso:
    public - default, qualquer coisa pode acessar
    private - outras classes não têm acesso à ela
    protected - só os filhos têm acesso
    internal - só poe ser acessado dentro do se projeto
    */
    private var resultado: BigDecimal = BigDecimal.ZERO

    fun somar(a: BigDecimal){
        resultado += a
        mostrarResultado()
    }

    fun subtrair(a: BigDecimal){
        resultado -= a
        mostrarResultado()
    }

    fun multiplicar(a: BigDecimal){
        resultado *= a
        mostrarResultado()
    }

    fun dividir(a: BigDecimal){
        resultado = resultado.divide(a, 8, RoundingMode.HALF_UP)
        mostrarResultado()
    }

    private fun mostrarResultado(){
        println("Resultado: $resultado")
    }
}