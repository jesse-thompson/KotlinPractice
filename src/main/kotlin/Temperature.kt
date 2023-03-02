class Temperature
{
    var celsius = 0.0
    var fahrenheit = 32.0

    override fun toString() = "$celsius Celsius is equal to $fahrenheit Fahrenheit"
}

fun main()
{
    var temp = Temperature()
    println(temp)   // default
    temp.celsius = 25.0
    println(temp)
    temp.fahrenheit = 86.0
    println(temp)
}