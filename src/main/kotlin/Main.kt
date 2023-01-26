fun main() {
    /*
    println("What's your name?")
    val name = readLine()
    println("Hello: $name!")

    var x = 10
    while (x > 1) {
        x--
        if (x < 3)
            println("inside IF")
    }

    var score = 10
    score = 11  //reassigned
    println(score)

    val pi: Double = 3.14   // val is like Java's FINAL
//    pi = 3.14   //error: val cannot be reassigned
    println(pi)

    var myArray = arrayOf(1,2,3)
    myArray = arrayOf(4,5)  //reassigned

    val yourArray = arrayOf(1,2,3)  //each array "value" is a pointer to the real value
    yourArray[2] = 6    //can be reassigned because this is the value at a pointer, not the value in the array
//    yourArray = arrayOf(4,5)    //error: val cannot be reassigned

    println("hi" == "hi")
    println("hi" == "Hi")
    println(null == "hi")
    println("hi" == null)
    println(null == null)

    val price = 12.25
    val taxRate = 0.08
    val output = "the amount $price after tax comes out to $${price * (1 + taxRate)}"

    val disclaimer = "the amount is in US$, that's right in \$only"
    println(output)
    println(disclaimer)

    val name = "Dr. Jung"
    val escaped = "The kid asked, \"How's it going, $name?\""

    val raw = """The kid asked, "How's it going, $name?" """

    println(escaped)
    println(raw)
     */

    val memo1 = """Dear Dr. Jung, a quick reminder about 
the party we have scheduled next Tuesday"""

    val memo2 = """Dear Dr. Jung, a quick reminder about 
        |the party we have scheduled next Tuesday""".trimMargin()

    // can define specific deliminator as desired
    val memo3 = """Dear Dr. Jung, a quick reminder about 
        ~the party we have scheduled next Tuesday""".trimMargin("~")

    println(memo1)
    println(memo2)
    println(memo3)
}