class Recipe (val title: String, val isVegetarian: Boolean = false)
fun main(){
    val r1 = Recipe("Chicken soup", false)
    val r2 = Recipe("Chicken soup", false)

    println(r1 == r2)  // false
    println(r1 === r2)  // false

    // If two objects are equal according to the == or equals(),,
    // then calling the hashCode() on each of the two objects
    // must produce the same integer result.
    println(r1.hashCode())  // 2061475679
    println(r2.hashCode())  // 140435067

    println(r1.toString())  // Recipe@7adf9f5f
    println(r2.toString())  // Recipe@85ede7b
}