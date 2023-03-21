// You can pass a lambda to a function
// As well as assigning a lambda to a variable,
// you can also use one or more, as function parameters
// lambda parameter called converter
fun convert(x: Double, converter: (Double) -> Double): Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun convertFive(converter: (Int) -> Double): Double {
    val result = converter(5)
    println("5 is converted to $result")
    return result
}
fun main(){
    // convert (20.0, {c: Double -> c * 1.8 + 32})

    // We can omit its type if compiler can infer type
    // convert (20.0, {c -> c * 1.8 + 32})

    // IF the final parameter of a function is a lambda,
    // you can move the lambda argument outside the ()'s
    // convert (20.0) {c -> c * 1.8 + 32}

    // we can use "it" because
    // each lambda uses a single parameter whose type the compiler can infer
    convert(20.0) {it * 1.8 + 32}

    // OR remove the ()'s entirely
    // There are no parenthesis in that function call
    // This is possible because the function has only one parameter, which is a lambda
    convertFive { it * 1.8 + 32}
}