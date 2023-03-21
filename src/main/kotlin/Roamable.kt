// Interface
// An interface lets you define common behavior OUTSIDE a superclass hierarchy
// Interfaces are used to define a protocol for common behavior
// so that you can benefit from polymorphism
// without having to rely on a strict inheritance structure
// A class can implement multiple interfaces, but can only inherit from a single superclass

// When you add an abstract function to an interface,
// there is no need to prefix the function name with the abstract keyword
// With and interface, the compiler automatically infers that a function with no-body
// must be abstract, so you don't have to mark it as such
interface Roamable {
    // Interface cannot have constructors

    // no need to prefix an abstract property with the abstract keyword
    var velocity: Int
        // Unlike properties in abstract classes, properties that are defined in
        // an interface can't store state, therefore can't be initialized
        // However, you can return a value for a property by defining a custom getter
        get() =20   // This returns 20 and you can override the property
        /*
        // Another restriction is that interface properties do not have "backing fields"
        // a backing field provides a reference to the underlying value of a property
        // you cannot define a custom setter that updates a property's value
        set(value){
            field = value   // this will not work
        }
        */
        // This will work because you are not using the "field" keyword
        // it won't update the underlying value of the property
        // You can define a setter so long as it does not reference "field"
        set(value){
            println("Unable to update velocity")
        }

    // This is NOT abstract function since there is a body
    // This is no "open", no "abstract" keyword, but still can be overridden
    fun roam(){
        // To add a concrete function to an interface, simply give it a body
        println("The Roamable is roaming")
    }
}
// The Vehicle class implements the Roamable interface
// Concrete class cannot contain abstract properties and function,
// so they MUST implement all abstract properties and functions that they inherit
class Vehicle: Roamable {
    // overridden is optional
    override fun roam(){
        println("The Vehicle is roaming")
    }
}