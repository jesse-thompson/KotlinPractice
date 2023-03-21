interface Silly {
    fun generate(): String
}

class Phrase(val list: List<Silly>) : Silly {
    override fun generate(): String {
        var result = ""
        for (item in list) {
            result += "${item.generate() } "
        }
        return result.trim()
    }
}

class Noun : Silly {
    private val options = listOf("boy", "girl", "car", "ball","toy","house",
        "food","bed","couch","chair","toilet","poop","kangaroo","cigarette lighter","fire")
    override fun generate() = options.random()
}

class Verb : Silly {
    private val options = listOf("is","loves","eats","buys","sells","watches",
        "hates","poops","farts","hits","pokes","barfs","explodes")
    override fun generate() = options.random()
}

class Determiner : Silly {
    private val options = listOf("this", "that", "a", "the")
    override fun generate() = options.random()
}

class Adjective : Silly {
    private val options = listOf("small", "big", "comfy", "disgusting", "dumb", "gassy", "sick", "whacky")
    override fun generate() = options.random()
}

class Adverb : Silly {
    private val options = listOf("quickly", "slowly", "happily", "angrily")
    override fun generate() = options.random()
}

class NP : Silly {
    val options = listOf(Phrase(listOf(Determiner(), Noun())),
                         Phrase(listOf(Determiner(), Adjective(), Noun())))
    override fun generate() = options.random().generate()
}

class VP : Silly {
    val options = listOf(Phrase(listOf(Verb(), NP())),
                         Verb(),
                         Phrase(listOf(Verb(),Adverb())))
    override fun generate() = options.random().generate()
}

class Sentence : Silly {
    override fun generate() = "${NP().generate()} ${VP().generate()}"
}

fun main() {
    val sentence = Sentence()
    println(sentence.generate())
}