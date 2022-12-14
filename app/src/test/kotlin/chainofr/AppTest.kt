/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package chainofr

import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class AppTest {
    private lateinit var newLocHandler: NewLocHandler
    private lateinit var complainHandler: ComplainHandler
    private var currentHandler: Handler? = null
    private lateinit var fanHandler: FanHandler
    private lateinit var spamHandler: SpamHandler
    private lateinit var mail: Mail

    @Test
    fun appHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

    @Test
    fun `Given a valid source and validate it is the same`() {
        assert(true)
        println("Happy Ending\n")
    }

    @Test
    fun `Given a null title mail and confirmed it won't be handled`(){

        givenAMail(null)
        thenNoMailBeenProcessed()

    }

    @Test
    fun `Given a spam mail and confirmed it's been deleted`() {

        givenAMail("best buy")
        whenASpamHandlerIsReady()
        thenMailBeenProcessed("deleting")

    }

    @Test
    fun `Given a Fan mail and confirmed it's been forawrd to CEO`() {
        givenAMail("big fan")
        whenAFanHandlerIsReady()
        thenMailBeenProcessed("CEO")

    }

    @Test
    fun `Given a Spam mail and when a spam and a fan handler are ready`() {
        givenAMail("best buy")
        whenAFanHandlerIsReady()
        thenMailBeenProcessed("deleting")

    }

    @Test
    fun `Given a New location mail and when all the handlers are ready`() {

        givenAMail("new loc at")
        whenAllHandlersAreReady()
        thenMailBeenProcessed("business")

    }

    private fun whenAllHandlersAreReady() {
        spamHandler = SpamHandler(mail.title)
        fanHandler = FanHandler(mail.title)
        complainHandler = ComplainHandler(mail.title)
        newLocHandler = NewLocHandler(mail.title)
        spamHandler.next = fanHandler
        fanHandler.next = complainHandler
        complainHandler.next = newLocHandler
        currentHandler = spamHandler
    }


    private fun whenAFanHandlerIsReady() {

        spamHandler = SpamHandler(mail.title)
        fanHandler = FanHandler(mail.title)
        spamHandler.next = fanHandler
        currentHandler = spamHandler

    }


    private fun thenNoMailBeenProcessed() {

        val result = currentHandler?.handleRequest(mail.title)
        assertNull(result)
        println("Null Ending\n")

    }

    private fun thenMailBeenProcessed( target:String) {

        val result = currentHandler?.handleRequest(mail.title)

        assertNotNull(result)
        assertContains(result, target)
    }

    private fun whenASpamHandlerIsReady() {

        spamHandler = SpamHandler(mail.title)
        currentHandler = spamHandler

    }

    private fun givenAMail(title: String?) {

        mail = Mail(title)

    }
}
