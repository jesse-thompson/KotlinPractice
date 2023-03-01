class Car3 (val yearOfMake: Int, theColor: String) {
    // Access Modifiers: public, private, protected and internal
    // protected: permission to the methods of the derived class
    // internal: permission for any code in the same module to access
    private var fuelLevel = 100

    /*
    // better than init or alternative solution
    private var fuelLevel = if (yearOfMake < 2020) 90 else 100
     */
    var color = theColor
        set (value){
            if (value.isBlank()){
                throw RuntimeException("no empty, please")
            }
            field = value
        }
    // Initializer blocks
    // When you need more complex than a simple expression or
    // there's extra code you want to run when each object is created
    // It will be executed when the object is initialized,
    // immediately after the constructor is called.
    // Your class can have multiple initializer blocks.
    // Each one runs in the order in which it appears in the class body.
    init {
        if (yearOfMake < 2020) {
            fuelLevel = 90
        }
    }
}

fun main(){

}
