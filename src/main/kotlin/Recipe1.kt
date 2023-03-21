// The data prefix turns a normal class into a data class
// Data classes automatically override their equals () function
// to change the behavior of the == operator so that
// it checks for object equality based on the values of each object's properties.
data class Recipe1 (val title: String, val isVegetarian: Boolean = false)

fun main(){
    val r1 = Recipe1("Chicken soup", false)
    val r2 = Recipe1("Chicken soup", false)

    // data class override equals() and ==
    println(r1 == r2)  // true
    println(r1 === r2)  // false
    println("3" + r1.equals(r2))

    // data class override hashCode()
    // Equal objects return the same hashCode
    println(r1.hashCode())  // 53239454
    println(r2.hashCode())  // 53239454

    // data class override toString()
    // toString() returns the value of each property
    println(r1.toString())  // Recipe(title=Chicken Soup, isVegetarian=false)
    println(r2.toString())  // Recipe(title=Chicken Soup, isVegetarian=false)
}