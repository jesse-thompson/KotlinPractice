fun main() {
    val groceries = listOf(
        Grocery ("Tomatoes", "Vegetable", "lb", 3.0,4),
        Grocery ("Mushrooms", "Vegetable", "lb", 4.0,1),
        Grocery ("Bagels", "Bakery", "Pack", 1.5,2),
        Grocery ("Olive oil", "Pantry", "Bottle", 6.0,2),
        Grocery ("Ice Cream", "Frozen", "Pack", 3.0,3))

    // search or filter a collection
    // most collections, filter returns a list (exception: Map)
    // returns a List containing those items from groceries whose category value is "Vegetable"
    // returns List of Groceries
    val vegetables = groceries.filter {it.category == "Vegetable"}
    println("vegetables: $vegetables\n")

    // There's whole FAMILY of filter functions
    // filterNot returns those items where the lambda body evaluates to false
    val notFrozen = groceries.filterNot {it.category == "Frozen"}
    println("not Frozen: $notFrozen\n")

    // The map function returns a List
    // Don't confuse this with data structure key/value map
    // There are many variations of the map functions
    // this example creates a new List, with the name of each Grocery item in groceries
    val groceryNames = groceries.map {it.name}
    println ("grocery Names: $groceryNames")

    // this returns a List containing each unitPrice multiplied by 0.5
    val halfUnitPrice = groceries.map {it.unitPrice * 0.5}
    println ("half Unit Price: $halfUnitPrice")

    // Calls filter function first, then calls map on the returning list
    val newPrices = groceries.filter {it.unitPrice > 3.0}.map { it.unitPrice * 2 }
    println ("new Prices: $newPrices\n")

    println("Grocery names:")
    groceries.forEach { println(it.name) }
    // groceries.map {it.name} // equivalent - different output type
    // for (item in groceries) println(item.name)     // equivalent code

    println("\nGroceries with unitPrice > 3.0: ")
    // as forEach is a function, you can use it in function call chains
    groceries.filter { it.unitPrice > 3.0 }.forEach { println (it.name) }
    /* // equivalent code
    for (item in groceries){
        if (item.unitPrice > 3.0)
            println(item.name)
    }*/

    // lambda's closure: The variables defined outside the lambda can access
    var itemNames = ""  // local variable that the lambda can access
    groceries.forEach { itemNames += "${it.name},  " }
    println ("item Names: $itemNames")
    //for (item in groceries) itemNames += "${item.name} " // equivalent code
}