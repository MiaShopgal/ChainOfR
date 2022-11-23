package chainofr

class FanHandler(private val title:String?, var next:Handler? = null):Handler {
    override fun handleRequest(input: String) = "$title".let {

        println("FanHandler is handling ... $it")

        if (title?.contains("fan") == true) {

            val result = "Fan mail handled by forwarding to CEO"
            println(result)
            return result

        }
        else{

            println("FanHandler cann't handle $it, passing to next")
            next?.handleRequest(it) ?: it

        }
    }
}
