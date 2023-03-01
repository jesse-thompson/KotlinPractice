// You may create more constructors, called secondary constructors
// Your secondary constructors are required to either call the primary constructor
// or call one of the other secondary constructors.
// Also, secondary constructors' parameters can't be decorated with val or var
// They don't define any properties.
// Only the primary constructor and declarations within the class may define properties
class Person (val first: String, val last: String) {
    // primary constructor defines two properties: first and last
    var fulltime = true
    var location: String = "?"
    // The first secondary constructor calls the primary constructor,
    // referring to it using this
    constructor(first: String, last: String, fte: Boolean): this(first, last){
        // initializing the field fulltime
        fulltime = fte
    }

    // The second secondary constructor may call either the first secondary constructor
    // or call the primary constructor
    constructor(first: String, last: String, loc: String): this(first, last, false){
        // initializing the field location
        location = loc
    }

    override fun toString() = "$first $last $fulltime $location"
}

fun main(){
    println(Person("Jane", "Doe"))
    println(Person("John", "Doe", false))
    println(Person("Baby", "Doe", "home"))
}
