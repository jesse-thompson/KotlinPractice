fun main() {
    exercise2()
}

/**
 * R: Rock
 * P: Paper
 * S: Scissor
 */
fun exercise2() {
    val options = arrayOf("R", "P", "S")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}
fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>):String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {
        print ("Please enter one of the following - ")
        for (item in optionsParam)
            print (" $item")
        print (": ")
        // TO DO: convert the following code using "when"
        val userInput = readLine()
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println ("You must enter a valid choice.")
        // end of TO DO
    }
    return userChoice
}
fun printResult (userChoice:String, gameChoice:String){
    // TO DO: convert the following code using "when"
    val result: String
    if (userChoice == gameChoice)
        result = "Tie!"
    else if ((userChoice == "R" && gameChoice == "S") ||
        (userChoice == "P" && gameChoice == "R") ||
        (userChoice == "S" && gameChoice == "P"))
        result = "You Win!"
    else
        result = "You Lose!"
    // end of TO DO
    println("You chose $userChoice. I chose $gameChoice. $result")
}