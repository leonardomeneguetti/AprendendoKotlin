package poo.heranca

import java.math.MathContext
import java.math.RoundingMode

//a classe está herdando da classe Calculadora
class CalculadoraCientifica: Calculadora() {
    fun potencia(a: Int){
        resultado = resultado.pow(a, MathContext(8, RoundingMode.HALF_UP))
        mostrarResultado()
    }
}