// prefix class with "abstract" to make it an abstract class
// An abstract class can contain abstract and non-abstract properties and functions
// It is possible for an abstract class to have no abstract members
// Abstract properties and functions do not need to be marked as open
abstract class Animal2 {
    // By marking a property as abstract,
    // you've decided that there's no useful initial value it can have
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    // abstract functions MUST be overridden in subclass
    // abstract functions do not have body
    abstract fun makeNoise()
    abstract fun eat()

    open fun roam() = println("The Animal is roaming")
    fun sleep() = println("The Animal is sleeping")
}

// The first concrete class must implement all abstract properties and functions
class Hippo2: Animal2 (){
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }
    override fun eat(){
        println("The Hippo is eating $food")
    }
}

// abstract subclass, you have a choice:
// you can either implement the abstract properties and functions, OR
// pass the buck to its subclasses
abstract class Canine2: Animal2(){
    override fun roam() = println("The Canine is roaming")
}

open class Wolf2: Canine2(){
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise()=println("Hooooowl!")
    final override fun eat() = println("The Wolf is eating $food")
}
class Vet2 {
    fun giveShot(animal2:Animal2){
        animal2.makeNoise()
    }
}
fun main(){
    // compile error
    //var a: Animal2 = Animal2()

    val a: Animal2 = Wolf2()
    a.makeNoise()   // calling from ?
    a.roam()        // calling from ?
    a.sleep()       // calling from ?
    println()
    
    val vet2 = Vet2()
    val wolf2 = Wolf2()
    val hippo2 = Hippo2()
    vet2.giveShot(wolf2)
    vet2.giveShot(hippo2)
}