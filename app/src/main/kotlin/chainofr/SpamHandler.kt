package chainofr

class SpamHandler(var next: Handler? = null) : Handler {
    override fun handleRequest(input: Mail): String {

        println("Spam handler is handling ...${input.title}")

        if (input.title.contains("buy")) {

            return "Spam mail handled by deleting"

        } else {
            
            next?.handleRequest(input)
            return "Passing to next Handler"

        }
    }
}
