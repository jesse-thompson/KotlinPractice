data class Recipe2 (val title: String, val isVegetarian: Boolean = false)

fun main(){
    // If you want to create a new copy of a data object,
    // altering some of its properties but leaving the rest intact,
    // you can do so using the copy() function.
    val r1 = Recipe2("Thai Curry", false)

    // Take a copy of r1's object, change the value of its isVegetarian property to true
    // and assign the new object to a variable named r2.
    val r2 = r1.copy(isVegetarian = true)
    val r3 = Recipe2("Thai Curry", false)
    val r4 = Recipe2("Chicken Soup", false)

    println("r1 == r2? ${r1 == r2}")  // false or true?
    println("r1 === r2? ${r1 ===r2}\n")  // false or true?

    println("r1 == r3? ${r1 == r3}")  // true or false?
    println("r1 === r3? ${r1 ===r3}\n")  // false or false?

    println("r1 hash code: ${r1.hashCode()}")
    println("r2 hash code: ${r2.hashCode()}")
    println("r3 hash code: ${r3.hashCode()}")
    println("r4 hash code: ${r4.hashCode()}\n")

    val noCopy1 = Recipe("Chicken soup", false)
    // compile error: no copy function since it is NOT data class
    //val noCopy2 = noCopy1.copy()

    // Data classes define componentN functions - destructuring data object
    val (title, vegetarian) = r4
    println("Title is $title and vegetarian is $vegetarian")

    println("Title is ${r4.component1()} and vegetarian is ${r4.component2()}")
    println("Title is ${r4.title} and vegetarian is ${r4.isVegetarian}")

}