// The Kotlin compiler wrote a constructor, defined a property,
// and added a getter to retrieve the value of that property.
// by default, the access to the class and its members is public
class Car (val yearOfMake: Int, var color: String)

fun main(){
    println(useCarObject())
}

fun useCarObject(): Pair<Int,String>{
    // creating an instance by calling constructor
    val car = Car(2023, "Red")
    val year = car.yearOfMake   // calling getter --> car.getYearOfMake()
    car.color = "Green"         // calling setter --> car.setColor()
    return year to car.color
}
