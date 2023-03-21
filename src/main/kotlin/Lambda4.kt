data class Grocery(val name: String, val category: String, val unit: String,
                   val unitPrice: Double, val quantity: Int)

fun main() {
    // The min and max functions work with basic types
    val ints = listOf(1,2,3,4)
    println (ints.maxOrNull())

   val groceries = listOf(
       Grocery ("Tomatoes", "Vegetable", "lb", 3.0,4),
       Grocery ("Mushrooms", "Vegetable", "lb", 4.0,1),
       Grocery ("Bagels", "Bakery", "Pack", 1.5,2),
       Grocery ("Olive oil", "Pantry", "Bottle", 6.0,2),
       Grocery ("Ice Cream", "Frozen", "Pack", 3.0,3))

    // find the item in groceries with the highest unitPrice
    // { i: item_type -> criteria }
    //val highestUnitPrice = groceries.maxByOrNull { i: Grocery -> i.unitPrice }

    // The Lambda must have one parameter, so we can just use "it"
     val highestUnitPrice = groceries.maxByOrNull { it.unitPrice }

    // The minBy or maxBy functions work with All types
    // take one parameter - a lambda that tells the function which property it should use


    // Note that return type of maxBy matches the type of the items held in the collection.
    // In this example - Grocery
    // unlike Java, it prints all contents since toString method is overridden in data class
    println ("highest Unit Price: $highestUnitPrice")

    // find the item in groceries with the lowest quantity
    val lowestQuantity = groceries.minByOrNull { it.quantity }
    println ("lowest Quantity: $lowestQuantity\n")

    // sumOf returns a sum of the items in a collection
    // In this example, sumOf return type is same as quantity --> Int
    val sumQuantity = groceries.sumOf{ it.quantity }
    println ("Sum Quantity: $sumQuantity")

    // In this example, return typ of sumOf is Double
    val totalPrice = groceries.sumOf{ it.quantity * it.unitPrice }
    println ("total Price: $totalPrice")
}