// There is no () after the name of the class
// so, the class has no defined constructor
class Duck {
    fun quack()=println("Quack! Quack! Quack!")
}
// whenever you define a class with no parameter
// the compiler adds a default constructor to your compiled code
// When you compile the above Duck class,
// the compiler treats it as though you'd written the following code:
/*
class Duck() {
    fun quack()=println("Quack! Quack! Quack!")
}
*/

fun main(){
    var myDuck = Duck()
    myDuck.quack()
    // This code will not compile
    // var myDuck = Duck
}
