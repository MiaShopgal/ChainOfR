package chainofr

class SpamMailHandler(val title: String?, var next: Handler? = null) : Handler {
    override fun handleRequst(previousProcess: String) {
        val result = "$previousProcess\nTitle in Spam Handler is : $title"
        if (title?.contains("buy") == true) {

            println ("Spam mail handled by deleting")

        } else {

            next?.handleRequst(result)
        }

    }

}
