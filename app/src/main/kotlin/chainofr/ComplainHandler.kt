package chainofr

class ComplainHandler(private val title: String?, var next: Handler? = null) : Handler {
    override fun handleRequest(input: String?): String = "$title".let {

        println("    ComplainHandler is handling ... ${it.uppercase()}")

        if (title?.contains("shit") == true) {

            val result = "### Complain mail handled by forawrding to legal department"
            println(result)
            return result

        } else {

            println(">>> ComplainHandler cann't handle $it, passing to next")
            next?.handleRequest(it) ?: it

        }
    }
}