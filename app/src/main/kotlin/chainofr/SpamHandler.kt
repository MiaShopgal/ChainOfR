package chainofr

class SpamHandler(var next: Handler? = null) : Handler {
    override fun handleRequest(input: Mail): String {

        println("Spam handler is handling ...${input.title}")

        return if (input.title.contains("buy")) {

            "Spam mail handled by deleting"

        } else {

            next?.handleRequest(input)
            "Passing to next Handler"

        }
    }
}
