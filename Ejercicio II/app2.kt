interface FizzBuzz {
    fun ejecutar()
}

class FizzBuzzImpl(val rangoInicio: Int, val rangoFin: Int) : FizzBuzz {

    init {
        if (rangoInicio > rangoFin) {
            throw IllegalArgumentException("El inicio del rango debe ser menor o igual al final del rango.")
        }
    }

    override fun ejecutar() {
        for (i in rangoInicio..rangoFin) {
            when {
                i % 3 == 0 && i % 5 == 0 -> print("FizzBuzz ")
                i % 3 == 0 -> print("Fizz ")
                i % 5 == 0 -> print("Buzz ")
                else -> print("$i ")
            }
            
            if (i % 10 == 0) {
                println()
            }
        }
    }
}

fun main() {
    try {
        print("Ingresa el inicio del rango: ")
        val rangoInicio = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Entrada inválida")
        
        print("Ingresa el final del rango: ")
        val rangoFin = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Entrada inválida")

        val fizzBuzz = FizzBuzzImpl(rangoInicio, rangoFin)
        fizzBuzz.ejecutar()
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
