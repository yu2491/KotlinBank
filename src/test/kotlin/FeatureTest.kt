import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class FeatureTest {

    val account = BankAccount(date = LocalDate.parse("2021-02-17"))

    @Test
    fun `prints blank statement`() {
        assertEquals("date || credit || debit || balance", account.printStatement())
    }

    @Test
    fun `prints 1 credit transaction`() {
        account.deposit(1000.00)
        assertEquals("date || credit || debit || balance\n17/02/2021 || 1000.00 || || 1000.00", account.printStatement())
    }

    @Test
    fun `prints 1 debit transaction`() {
        account.balance = 1000.00
        account.withdraw(250.00)
        assertEquals("date || credit || debit || balance\n17/02/2021 || || 250.00 || 750.00",account.printStatement())
    }

    @Test
    fun `prints multiple transactions in reverse order`() {
        account.balance = 1000.00
        account.deposit(1000.00)
        account.deposit(2000.00)
        account.withdraw(500.00)
        val expectedString = "date || credit || debit || balance\n17/02/2021 || || 500.00 || 3500.00\n17/02/2021 || 2000.00 || || 4000.00\n17/02/2021 || 1000.00 || || 2000.00"
        assertEquals(expectedString,account.printStatement())
    }

}