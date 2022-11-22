package chainofr

interface Handler {
    fun handleRequst(previousProcess: String)
}
