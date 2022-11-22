package chainofr

class FanHandler(var next:Handler? = null):Handler {
    override fun handleRequest(input: Mail): String {
        
        println("Fan Handler is handling ...${input.title}")

        return if (input.title.contains("fan")) {

            "Fan mail forwarded to CEO"

        } else {

            next?.handleRequest(input)
            "Passing to next Handler"

        }
    }
}
