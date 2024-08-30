interface Numero {
    val valor: Int
    fun esPar(): Boolean
    fun esImpar(): Boolean
    fun esPrimo(): Boolean
}

class NumeroPar(override val valor: Int) : Numero {
    override fun esPar() = true
    override fun esImpar() = false
    override fun esPrimo() = false
}

class NumeroImpar(override val valor: Int) : Numero {
    override fun esPar() = false
    override fun esImpar() = true
    override fun esPrimo(): Boolean {
        if (valor < 2) return false
        for (i in 2..valor / 2) {
            if (valor % i == 0) return false
        }
        return true
    }
}

class ContadorNumeros(val n: Int) {

    fun contarNumeros() {
        var primos = 0
        var pares = 0
        var impares = 0

        for (i in 1..n) {
            val numero = if (i % 2 == 0) NumeroPar(i) else NumeroImpar(i)

            if (numero.esPrimo()) primos++
            if (numero.esPar()) pares++
            if (numero.esImpar()) impares++
        }

        println("Prime numbers count: $primos")
        println("Even numbers count: $pares")
        println("Odd numbers count: $impares")
    }
}

fun main() {
    try {
        print("Ingresa un número entero positivo: ")
        val n = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Entrada inválida")
        if (n <= 0) throw IllegalArgumentException("El número debe ser mayor que 0")

        val contador = ContadorNumeros(n)
        contador.contarNumeros()
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
