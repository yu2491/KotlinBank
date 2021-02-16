import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StatementTest {

    val subject = Statement()

    @Test
    fun `Returns just the header if no transactions are stored`() {
        val statement = subject.getStatement()
        assertEquals("date || credit || debit || balance", statement)
    }



}