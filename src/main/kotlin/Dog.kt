class Dog (val name:String, theWeight: Int, theBreed:String) {

    var activities = arrayOf("Sleep")
    private val breed = theBreed.uppercase()

    init {
        println("Dog $name has been created")
    }

    init {
        println("The breed is $breed")
    }

    // custom setter()
    var weight = theWeight
        set(value){
            if (value > 0) field=value
        }

    // custom getter()
    val weightInKgs:Double
        get()=weight / 2.2  


    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof")
    }
}


fun main() {
    val myDog = Dog("Fido", 70, "Mixed")
    myDog.bark()

    println(myDog.name)
    myDog.weight = 75
    println("Weight in Kgs is ${myDog.weightInKgs}")    // 75/2.2

    myDog.weight = -2
    println("Weight is ${myDog.weight}")

    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for (item in myDog.activities){
        println("My dog enjoys $item")
    }
    println()
    val dogs = arrayOf(Dog("Fido", 70, "Mixed"), Dog("Ripper",10,"Poodle"))
    dogs[1].weight=15
    dogs[1].bark()
}
