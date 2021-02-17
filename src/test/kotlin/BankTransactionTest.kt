import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class BankTransactionTest {

    val subject = BankTransaction("credit",1000.00, LocalDate.parse("2021-02-16"))

    @Test
    fun `it returns it date in string format`() {
        assertEquals("16/02/2021", subject.getDate())
    }

    @Test
    fun `It returns amount to 2 decimal places`() {
        assertEquals("1000.00", subject.getAmount())
    }

    @Test
    fun `It returns type of transaction`() {
        assertEquals("credit", subject.type)
    }



}