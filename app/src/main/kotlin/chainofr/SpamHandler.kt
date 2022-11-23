package chainofr

class SpamHandler(private val title:String?, var next: Handler? = null) : Handler {
    override fun handleRequest(input: String?) = "$title".let {

        println("    SpamHandler is handling ... ${it.uppercase()}")

        if (title?.contains("buy") == true) {

            val result = "### Spam mail handled by deleting  ###\n"
            println(result)
            return result

        }
        else{

            println(">>> SpamHandler  cann't handle $it, passing to next")
            next?.handleRequest(it) ?: it

        }
    }


//
//    {
//
//        println("Spam handler is handling ...${input.title}")
//
//        return if (input.title.contains("buy")) {
//
//            "Spam mail handled by deleting"
//
//        } else {
//
//            next?.handleRequest(input)
//            "Passing to next Handler"
//
//        }
//    }
}
