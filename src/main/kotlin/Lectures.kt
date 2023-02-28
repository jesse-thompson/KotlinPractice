import kotlin.math.roundToInt
fun main(){
    lectures()
}
fun lectures(){
    // Pair and Triple
    // Create an instance of Pair using the constructor
    val pairExample = Pair("Tom","Jerry")
    println(pairExample)

    // to() extension function, that is available on any object in Kotlin
    // create pairs of entries for a Map.
    // function to() creates an instance of Pair,
    // the first value is the key and the second is the value.
    val mapExample = mapOf("Tom" to "Cat", "Jerry" to "Mouse")
    println("$mapExample\n")

    // How to create airport code with temperature?
    val airportCode = listOf("LAX", "SFO", "PDX", "SEA")
    println (airportCode)

    // Collect the temperature values for different airport codes
    // Iterate over the collection airportCodes using the functional-style map() iterator,
    // transform each airport code in the list to the pair of (code, temperature).
    // The result is a list of Pair<String,String>.
    // Loop through the values in the list of Pairs
    // For each Pair, we obtain the two contained values using the first and second property.

    val temperatures = airportCode.map {code -> code to getTemperatureAtAirport(code) }
    for (temp in temperatures) {
        println ("Airport: ${temp.first}: Temperature: ${temp.second}")
    }
    println("\n*** ListOf ***")
    // listOf() vs. mutableListOf()
    val fruits: List<String> = listOf("Apple", "Banana", "Grape")
    println (fruits)

    // use .get() or []
    println ("${fruits.get(1)}, ${fruits[2]}")
    println(fruits.contains("Apple"))   // Java style
    println("Apple" in fruits)      // Kotlin style
    // fruits.add("Orange")    // ERROR

    val fruits2 = fruits + "Orange"
    println(fruits2)
    val fruits3 = fruits2 - "Banana"
    println(fruits3)

    val fruitsMutable: MutableList<String> = mutableListOf("Apple", "Banana", "Grape")
    fruitsMutable.add("Tomato")
    println (fruitsMutable)

    println("\n*** MapOf ***")
    // mapOf(), mutableMapOf() from java.util.Map<T>
    // hashMapOf() from java.utill.HashMap<T>
    // linkedMapOf() from java.utill.LinkedHashMap<T>
    // sortedMapOf() from java.utill.SortedMap<T>
    val sites = mapOf("google" to "https://www.google.com", "agiledeveloper" to "https://www.agiledeveloper.com")
    println(sites.size) // 2

    // Iterate Map
    println(sites.containsKey("agiledeveloper"))    // true, java style
    println(sites.containsValue("https://www.agiledeveloper.com"))  // true, java style
    println("agiledeveloper" in sites)  // true
    println("https://www.agiledeveloper.com" in sites) // false, only check keys, not values

    println(sites["google"])
    val googleSite = sites["google"]    // Type is String?
    // this will not work because it returns a nullable type
    //val googleSite: String = sites["google"]
    println(googleSite)
    println(sites["Microsoft"])    // will print null

    // Alternatively,we can avoid the nullable reference type by providing an alternate,
    // default value if the key doesn't exist
    // Type is String, not String?
    val googleSite2 = sites.getOrDefault("Microsoft","http://www.bridgew.edu")
    println("This will print default value $googleSite2\n")

    val sitesWithExample = sites + ("example" to "http://www.example.com")
    for (entry in sitesWithExample) {
        println ("${entry.key} ... ${entry.value}")
    }
    println("----")
    val withoutAgileDeveloper = sitesWithExample - "agiledeveloper"
    for ((key, value) in withoutAgileDeveloper) {
        println ("$key ... $value")
    }
    println()

    // Nullable Reference
    println ("testing nickName1 - nullable types have a ? suffix")
    println(nickName1("William"))
    println(nickName1("Jacob"))
    println(nickName1(null))

    // ? Safe-Call Operator.
    println("testing nickName2 - Safe-Call Operator ?")
    println(nickName2("William"))
    println(nickName2("Jacob"))
    println(nickName2(null))

    println("testing nickName3 - Safe-Call Operator ?")
    println(nickName3("William"))
    println(nickName3("Jacob"))
    println(nickName3(null))

    // ?: Elvis Operator
    println("testing nickName4 - Elvis Operatir ?:")
    println(nickName4("William"))
    println(nickName4("Jacob"))
    println(nickName4(null))

    println("*** as? ***")
    // Type Checking and Type Casting
    for (id in 1..2) {
        println("Message: ${(fetchMessage(id))}")
        //println("Message Length: ${(fetchMessage(id).length)}") // Not working

        //println("Message Length: ${(fetchMessage(id).toString().length)}")
        // Okay. as? operator will assign null to the reference upon failure
        //println("Message Length: ${(fetchMessage(id) as? String)?.length}")
        println("Message Length: ${(fetchMessage(id) as? String)?.length ?: "Not String Type"}")

        // class java.lang.StringBuilder cannot be casting to class java.lang.String
        // as operator blows up if the casting fails,
        //println("Message Length: ${(fetchMessage(id) as String).length}")
    }
}


//  "${Math.round(Math.random() * 30) + code.count()} C"
fun getTemperatureAtAirport(code:String):String =
    "${(Math.random() * 30).roundToInt() + code.count()} C"
/*
fun nickName0(name: String): String{
    if (name != null)
        return name.reversed()
    return null // ERROR
}
*/
fun nickName1(name: String?): String?{
    if (name != null)
        return name.reversed()
    return null
}

// Safe-call operator returns null if the target is null
// We can merge the null check and the call to a method or property into one step using ?
// If the reference is null, the safe-call operator will result in null.
fun nickName2(name:String?): String? = name?.reversed()
fun nickName3(name:String?): String? = name?.reversed()?.uppercase()

// ?: Elvis Operator
// takes String? to allow null arguments, but the return type is String (not String?)
fun nickName4(name:String?): String = name?.reversed()?.uppercase()?:"Joker"
/*
fun nickName4(name:String?): String{
    val result = name?.reversed()?.uppercase()
    if (result == null)
	    return "Joker"
    else
	    return result
}
*/

fun fetchMessage(id: Int): Any =
    if (id ==1) "Record found" else StringBuilder("data not found")
    //if (id ==1) "Record found" else "data not found"
