// We want to use the class as a superclass: use keyword open
open class Animal {
    // POSSIBLE to override image, food and habitat properties --> use keyword open
    open val image = ""
    open val food = ""
    open val habitat = ""
    // you cannot override hunger
    var hunger = 10

    // may override functions - makeNoise(), eat(), roam()
    open fun makeNoise() = println("The Animal is making a noise")
    open fun eat() = println("The Animal is eating")
    open fun roam() = println("The Animal is roaming")
    // cannot override function sleep()
    fun sleep() = println("The Animal is sleeping")
}

// This is like saying "class Hippo is a subtype of class Animal"
// The Animal() after the : calls the Animal's constructor.
// This ensures that any Animal initialization code gets to run
// Calling the superclass constructor is mandatory
class Hippo: Animal(){
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    // The function parameters in the subclass must match those in the superclass
    // The function return types must be compatible
    override fun makeNoise() {
        println("Grunt! Grunt!")
    }
    override fun eat(){
        println("The Hippo is eating $food")
    }
    // didn't override roam()
    // cannot override sleep()
}

open class Canine: Animal(){
    override fun roam() = println("The Canine is roaming")
}

open class Wolf: Canine(){
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise()=println("Hooooowl!")
    // Declaring the function eat() as final in the Wolf class
    // means that it can no longer be overridden in any of Wolf's subclass
    final override fun eat() = println("The Wolf is eating $food")
}
class Vet {
    fun giveShot(animal:Animal){
        animal.makeNoise()
    }
}
fun main(){
    val a: Animal = Wolf()
    a.makeNoise()   // calling from ?
    a.roam()        // calling from ?
    a.sleep()       // calling from ?
    println()

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShot(wolf)
    vet.giveShot(hippo)
    println()

    val animals = arrayOf(hippo, wolf)
    for (item in animals){
        item.roam()
        item.eat()
    }
}