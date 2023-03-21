fun main() {
    val groceries = listOf(
        Grocery ("Tomatoes", "Vegetable", "lb", 3.0,4),
        Grocery ("Mushrooms", "Vegetable", "lb", 4.0,1),
        Grocery ("Bagels", "Bakery", "Pack", 1.5,2),
        Grocery ("Olive oil", "Pantry", "Bottle", 6.0,2),
        Grocery ("Ice Cream", "Frozen", "Pack", 3.0,3))

    // group the items in your collection - same as SQL group by
    // groceries.groupBy {it.category } means
    // "group each item in groceries by its category value"
    // groupBy returns a Map
    // key: each criteria, value: List of items
    groceries.groupBy {it.category }.forEach {
        // prints the Map key (Grocery category)
        println(it.key)
        // gets the corresponding value: List<Groceries>, for the Map's key
        it.value.forEach { println ("   ${it.name}") }
    }

    // fold function - one of the flexible higher-order functions
    // specify initial value and perform some operation on it for each item
    // take two parameters: initial value and operation

    // 1. creates an Int variable named runningSum which is initialized with 0.
    //      This variable is local to the fold function
    // 2. The function takes the value of the first item in the collection
    //      (1 in this example) and adds it to runningSum
    // 3. The function add 2 to runningSum (now runningSum is 3)
    // 4. The function add 3 to runningSum (now runningSum is 6)
    // 5. The function add 4 to runningSum (now runningSum is 10)
    // 6. The function returns the final value of runningSum to sumOfInts
    val ints = listOf(1, 2, 3, 4)
    val sumOfInts = ints.fold(0) { runningSum, item -> runningSum + item}
    println ("\nsum Of Ints: $sumOfInts")   // 1+2+3+4

    val productOfInts = ints.fold(1) { runningProduct, item -> runningProduct * item}
    println ("productOfInts: $productOfInts")   // 1*2*3*4

    // Concatenate together the name of each item in a List<Grocery>
    val names = groceries.fold ("") {str, item -> str + "  ${item.name}"}
    println ("names: $names")

    //Subtract the total price (unitPrice*quantity) of items from an initial value (50.0)
    val changeFrom50 = groceries.fold (50.0) { change, item -> change - item.unitPrice * item.quantity}
    println ("changeFrom50: $changeFrom50") //50 - 3*4 - 4*1 - 1.5*2 - 6*2 - 3*3
}