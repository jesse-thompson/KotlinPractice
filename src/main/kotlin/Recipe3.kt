// Data class must have a primary constructor,
// which must define at least one parameter.
data class Recipe3(val title: String,
                   val isVegetarian: Boolean = false,
                   val difficulty: String = "easy"){
    var mainIngredient = ""
}

fun main(){
    val r1 = Recipe3 ("Thai Curry", difficulty = "difficult")
    r1.mainIngredient = "Chicken"

    val r2 = Recipe3 ("Thai Curry", difficulty = "difficult")
    r2.mainIngredient = "Beef"

    //  ==, toString(), hashcode(), copy() only include
    // the properties defined in the primary constructor
    // (e.g., title, isVegetarian, difficulty)
    println (r1 == r2) // true (only for constructor variables)
    println(r1.equals(r2))
    println(r1.toString())  // Recipe3(title=Thai Curry, isVegetarian=false, difficulty=difficult)
    println(r2.toString())  // Recipe3(title=Thai Curry, isVegetarian=false, difficulty=difficult)
    println("r1 hash code: ${r1.hashCode()}")
    println("r2 hash code: ${r2.hashCode()}")
    println()

    val r3 = r1.copy()
    println("r3.mainIngredient ${r3.mainIngredient}")
    r3.mainIngredient = "Pork"
    println (r1 == r3)
}