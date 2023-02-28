fun main(){
    println(exercise1("William"))
    println(exercise1("Jacob"))
    println(exercise1(null))
}
fun exercise1(name:String?) = when (name){
    null -> "Joker"
    else -> name.reversed().uppercase()
}