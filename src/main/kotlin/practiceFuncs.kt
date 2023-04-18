import java.time.DayOfWeek
import kotlin.math.roundToInt
import kotlin.random.Random

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

    for (i in (1..9).filter { it % 3 == 0 || it % 5 == 0 })
        print("$i ")
    println()

    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    for (e in list) print("$e")
    val names = listOf("Tom", "Jerry", "Spike")
    for (index in names.indices)
        println("Position of ${names[index]} is $index")  // without {}, will only print whole array plus index

    // get both index and value
    for ((index, name) in names.withIndex())
        println("Position of $name is $index")

    for (i in (1..9))
    {
        println(isAlive3(alive = true, i))
        println(isAlive3(alive = false, i))
    }

    val days = listOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")
    for (day in days)
        println(whatToDo(day))

    val days = listOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")
    for (day in days)
        printWhatToDo(day)

    println(systemInfo1())

    fizzBuzz()

    guessNumber()

    println(Pair("Tom", "Jerry"))

    println(mapOf("Tom" to "Cat", "Jerry" to "Mouse"))

    val airportCode = listOf("LAX", "SFO", "PDX", "SEA")

    // iterate airportCode using map()
    // List.map() transform each airport code to the pair of code, temperature
    // var temperatures will hold Pair <String,String>
    val temperatures =
        airportCode.map { code -> code to getTemperatureAtAirport(code) }
    println(temperatures)

    for (temp in temperatures)
    {
        println("Airport: ${temp.first}; Temperature: ${temp.second}")
    }

    // listOf() is immutable
    // mutableListOf() is mutable
    val fruits: List<String> = listOf("Apple", "Banana", "Grape")
    println(fruits)

    // use .get() or []
    println("f1: ${fruits.get(1)}, ${fruits[2]}")
    println("Apple" in fruits)
    // fruits.add("Orange") gives ERROR

    val fruits2 = fruits + "Orange"
    println("f2: $fruits2")
    val fruits3 = fruits2 - "Banana"
    println("f3: $fruits3")

    val fruitsMutable: MutableList<String> =
        mutableListOf("Apple", "Banana", "Grape")
    fruitsMutable.add("Tomato")
    println("fm: $fruitsMutable")

    val sites: Map<String,String> =
        mapOf("google" to "https://google.com", "agiledevelper" to "https://agiledeveloper.com")
    println(sites.size)

    // iterate map (can only check keys, not values)
    println("agiledevelper" in sites)

     */
    // convert using filter and map funcs
    var doubleOfEven = mutableListOf<Int>()
    for (i in 1..100)
        if (i % 2==0)
            doubleOfEven.add(i*2)

    println(doubleOfEven)

    println((1..100).filter { it % 2==0 }.map { it * 2 })

    // convert w/o using higher order funcs
    // none returns false if lambda (predicate) returns true
    // none returns true if no elements match the given predicate
    fun isPrime(n: Int) = n > 1 && (2 until n).none { n % it == 0 }

    println(isPrime(1)) // false
    println(isPrime(2)) // true
    println(isPrime(3)) // true
    println(isPrime(4)) // false

    fun issPrime(n: Int): Boolean
    {
        if (n < 2) return false
        for (i in 2 until n)
        {
            if (n % i == 0)
                return false
        }
        return true
    }
}



// return keyword is not allowed for single line function
fun greet() = "I am Groot"
//fun greet(): String = "Hello"
fun greet(name: String) = "Hello $name" //can overload previous greet() because it has a different parameter input

//val message: Int = greet()  // causes error
fun sayHello() = println("Well, hello")

// "Unit" type is similar to Java's "void" type
//val message: Unit = sayHello()

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

fun isAlive3(alive: Boolean, numberOfLiveNeighbor: Int) =
    (numberOfLiveNeighbor == 3) || (alive && (numberOfLiveNeighbor == 2))

fun whatToDo(dayOfWeek: Any) = when (dayOfWeek)
{
    "Sat", "Sun", -> "Relax"
    in listOf("Mon", "Tues", "Wed", "Thur") -> "work hard"
    in 2..4 -> "work hard"
    "Fri" -> "Party"
    is String -> "What?"
    else -> "No Clue"
}

fun printWhatToDo(dayOfWeek: Any)
{
    when (dayOfWeek)
    {
        "Sat", "Sun", -> println("Relax")
        in listOf("Mon", "Tues", "Wed", "Thur") -> println("work hard")
        in 2..4 -> println("work hard")
        "Fri" -> println("Party")
        is String -> println("What?")
        else -> println("No Clue")
    }
}

fun systemInfo1(): String
{
    val numberOfCores = Runtime.getRuntime().availableProcessors()

    return when (numberOfCores)
    {
        1 -> "1 core, packing this one off to the museum"
        in 2..6 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores! I want your machine"
    }
}

fun systemInfo2(): String
{

    return when (val numberOfCores = Runtime.getRuntime().availableProcessors())
    {
        1 -> "1 core, packing this one off to the museum"
        in 2..6 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores! I want your machine"
    }
}

// basically a switch statement, using when
fun fizzBuzz()
{
    for (i in 1..100)
        when
        {
            (i % 15 == 0) -> println("FizzBuzz")
            (i % 3 == 0) -> println("Fizz")
            (i % 5 == 0) -> println("Buzz")
            else -> println(i)
        }
}

fun guessNumber()
{
    val n: Int = 1 + Random.nextInt(10)
    println("Guess a number from 1 to 10\n")
    while (true)
    {
        print("Your guess: ")
        when (readlnOrNull()?.toInt())
        {
            in n+1..10 -> println("Too High")
            in n..n-1 -> println("Too Low")
            n -> {println("Correct!"); break}
            else -> println("Try Again")
        }
    }
}

//fun getTemperatureAtAirport(code: String): String =
//    "${(Math.random() * 30).roundToInt() + code.count()} C"
