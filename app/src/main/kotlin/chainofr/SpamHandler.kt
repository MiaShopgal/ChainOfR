package chainofr

class SpamHandler(var next: Handler? = null) : Handler {
    override fun handleRequest(input: Mail) {

        println("Spam handler is handling ...${input.title}")

        if (input.title.contains("buy")) {

            println("Spam mail handled by deleting")

        } else {
            
            next?.handleRequest(input)

        }
    }
}
