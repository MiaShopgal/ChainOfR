package chainofr

interface Handler {
    fun handleRequest(input: Mail): String
}
