fun main(){
    var addFive = {x: Int -> x+5}
    // simpler way
    println ("Pass 6 to addFive: ${addFive(6)}")
    // Alternative: Execute a lambda’s code by invoking it
    println ("Pass 6 to addFive: ${addFive.invoke(6)}")

    val addInts = {x: Int, y:Int -> x + y}
    println ("Pass 6, 7 to addInts: ${addInts(6, 7)}\n")

    // A lambda's type is known as a function type
    // When you assign a lambda to a variable, the compiler infers the variable's type
    // from the lambda that's assigned to it, but you can explicitly define it.
    // val intLambda: (Int, Int) -> Int = {Int: x, Int: y -> x*y}

    // The compiler knows that x and y needs to be an Int, so we can omit its type
    // Note that ()'s: (Int, Int).
    // It is because of curried function (associates to the right)
    val intLambda: (Int, Int) -> Int = {x, y -> x*y}
    println ("Pass 10, 11 to intLambda: ${intLambda(10,11)}")

    // alternative way - curried function
    // val intLambdaCurried: (Int) -> (Int) -> Int = {x -> {y -> x * y}}
    // println ("Pass 10, 11 to intLambdaCurried: ${intLambdaCurried(10)(11)}")

    // Can replace a single parameter with "it" since compiler can infer its type
    // val addSeven: (Int) -> Int = {x -> x + 7}
    // This will not work since compiler cannot infer its type
    // val addSeven = {it + 7}  // No Way!
    val addSeven: (Int) -> Int = {it + 7}
    println ("Pass 12 to addSeven: ${addSeven(12)}")

    // even if the lambda has no parameters,
    // its type definition still includes the ()'s
    //val myLambda:() -> Unit = { println("Hi!") }
    val myLambda = { println("Hi!") }
    myLambda()
}