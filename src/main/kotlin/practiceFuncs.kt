fun main()
{
    /*
    println(greet())
    println(greet("Eve"))
    println("The result of sayHello is $message")

    createPerson("Jake", 12, 152, 43)
    createPerson(name = "Josh", age = 13, height = 155, weight = 45)
    createPerson("Bo", height = 140, weight = 135)
    createPerson(height = 150, weight = 148, name = "Greg")
//    createPerson(height = 25, weight = 65, "Kyle")    // error: mixing named and positioned arguments not allowed

    greetMany("Hello", "Tom", "Jerry", "Spike", num = 5)
//    greetMany("Tom", "Jerry", "Spike", "Hello", 5)  //parameters after vararg need to be named

    println(max1(intArrayOf(1,2,3,4,5)))
    println(max2(1,2,3,4,5,6,7))
    println(max2(*intArrayOf(1,2,3,4,5,6,7,8))) // needs * spread operator else error

    // Destructuring
    val (fst, snd, trd) = getFullNames()
    println("$fst $snd $trd")

     */

    //Range Classes
    val oneToFive: IntRange = 1..5
    val aToE: CharRange = 'a'..'e'

    //Forward iteration
    for (i in 1..5)
        println("1 $i")
    for (ch in 'a'..'e')
        println(ch)

    //Reverse iteration
    for (i in 5.downTo(1))
        println("a $i")
    for (i in 5 downTo 1)
        println("b $i")

    // Skipping values in Range
    for (i in 1 until 5)
        println("c $i")
    for (i in 1 until 10 step 3)
        println("d $i")
    for (i in 10 downTo 0 step 3)
        println("e $i")

}

// return keyword is not allowed for single line function
fun greet() = "I am Groot"
//fun greet(): String = "Hello"
fun greet(name: String) = "Hello $name" //can overload previous greet() because it has a different parameter input

//val message: Int = greet()  // causes error
fun sayHello() = println("Well, hello")

// "Unit" type is similar to Java's "void" type
val message: Unit = sayHello()

fun createPerson(name: String, age: Int=1, height: Int, weight: Int)
{
    println("$name $age $height $weight")
}

fun greetMany(msg: String, vararg names: String, num: Int)
{
    println("$msg ${names.joinToString(", ")}")
}

fun max1(numbers: IntArray): Int
{
    var large = Int.MIN_VALUE
    for (number in numbers)
        large = if (number > large) number else large
    return large
}

fun max2(vararg numbers: Int): Int
{
    var large = Int.MIN_VALUE
    for (number in numbers)
        large = if (number > large) number else large
    return large
}

//Destructuring
fun getFullNames() = Triple("John", "Quincy", "Adams")


