interface Roamable3{
    fun roam()
}
// Note that there is no () after Roamable3 because it is an interface
abstract class Animal3: Roamable3 {
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    abstract fun makeNoise()
    abstract fun eat()

    // from interface roam()
    override fun roam() = println("The Animal is roaming")
    fun sleep() = println("The Animal is sleeping")
}
class Hippo3: Animal3 (){
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
abstract class Canine3: Animal3(){
    override fun roam() = println("The Canine is roaming")
}
open class Wolf3: Canine3(){
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"
    override fun makeNoise()=println("Hooooowl!")
    override fun eat() = println("The Wolf is eating $food")
}

class Vehicle3: Roamable3 {
    // overridden is required since roam function had no-body in interface
    override fun roam(){
        println("The Vehicle is roaming")
    }
}

class Vet3 {
    fun giveShot(animal3:Animal3){
        animal3.makeNoise()
    }
}

fun main(){
    val roamables = arrayOf(Hippo3(), Wolf3(), Vehicle3())
    val vet3 = Vet3()
    for (item in roamables){
        item.roam() // what does this print?
        // Use the "is" operator to check
        // if the underlying object is the specified type
        if(item is Animal3) {
            item.eat()  // print?
        }

        // In conditions using && and ||
        // the right side of the if condition only runs if roamable is an Animal
        // so we can access its hunger property
        if (item is Animal3 && item.hunger >=10){   // if A is false, it will not go to B
            // code to deal with a hunger Animal
            vet3.giveShot(item) // print?
        }

        // The right side of an || condition
        // only runs if the left side is false
        // Therefore, the right side can only run if roamable is an Animal
        if (item !is Animal3 || item.hunger >=5){   // if A is true, it will not go to B
            // code to deal with a non-Animal, or with a non-hungry Animal
            item.roam() // print?

        }
        println()
    }
}
