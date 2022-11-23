package chainofr

class NewLocHandler(private val title: String?, var next: Handler? = null) : Handler {
    override fun handleRequest(input: String?): String = "$title".let {

        println("    NewLocHandler is handling ... ${it.uppercase()}")

        if (title?.contains("loc") == true) {

            val result = "### New location mail handled by forwardind to business development ###\n"
            println(result)
            return result

        } else {

            println(">>> NewLocHandler  cann't handle $it, passing to next")
            next?.handleRequest(it) ?: it
        }
    }

}