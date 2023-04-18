// A function can return a lambda
fun getConversionLambda(str: String): (Double) -> Double = {
    when(str){
        "CelsiusToFahrenheit" -> it * 1.8 + 32.0
        "KgsToPounds" -> it * 2.204623
        "PoundsToUSTons" -> it / 2000.0
        else -> it
    }
}

/*
fun getConversionLambda(str: String): (Double) -> Double {
    if (str == "CentigradeToFahrenheit") return {it *1.8 + 32}
    else if (str == "KgsToPounds") return {it * 2.204623}
    else if (str == "PoundsToUSTons") return {it / 2000.0}
    else return {it}
}
*/


typealias DoubleConversion = (Double) -> Double // for readability to simplify stuff below

fun convert3 (x: Double, converter: DoubleConversion): Double{
    val result = converter(x)
    println("function convert3: $x is converted to $result")
    return result
}
fun combine(lambda1: DoubleConversion, lambda2: DoubleConversion): DoubleConversion{
    return { x:Double -> lambda2(lambda1(x)) }
}

fun main(){
    // convert 2.5 kg to Pounds
    // You can invoke the lambda returned by a function, or
    // use it as an argument for another function
    // println("Convert 2.5 kg to Pounds: ${getConversionLambda("KgsToPounds").invoke(2.5)}")
    println("Convert 2.5kg to Pounds: ${getConversionLambda("KgsToPounds")(2.5)}\n")


    // define two conversion lambda
    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

    // combine the two lambdas to create a new one
    // returned function: lambda2(lambda1(x)) == poundsToUSTonsLambda(kgsToPoundsLambda(x))
    val kgsToUSTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)

    // Use the new lambda to convert 17.4 KG to US Tons
    // (17.4 * 2.204623 ) / 2000.0
    val value = 17.4
    println("$value kgs is ${convert3(value, kgsToUSTonsLambda)} US Tons")
}