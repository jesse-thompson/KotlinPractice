import java.lang.RuntimeException

// What if someone sets color to an empty string?
// theColor will not be given a value through the constructor
// yearOfMake: property
// theColor: constructor parameter variable
class Car2 (val yearOfMake: Int,  theColor: String) {
    // property - getter and setter will be created
    var fuelLevel = 100
    // color is property Java: this.color = theColor
    // only getter will be created automatically
    // this is custom setter
    // A setter has one parameter - proposed new value
    var color = theColor
        set (value){
            // The setter updates the value of the color property
            if (value.isBlank()){
                throw RuntimeException("no empty, please")
            }
            // by means of the field identifier. "field" refers to the property
            field = value
            // DON'T DO THIS: Infinite loop by calling setter again...
            // color = value
        }
}

fun main(){
    val car2 = Car2(2023, "Red")
    car2.color = "Green"
    car2.fuelLevel--
    println(car2.fuelLevel)
    //println(car2.theColor)
    try {
        car2.color = ""
    } catch (ex: Exception){
        println(ex.message) // Java: getMessage()
    }
    println(car2.color)
}
