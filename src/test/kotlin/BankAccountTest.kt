import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class BankAccountTest {

    val account = BankAccount()

    @Test
    fun `Balance is 0 to start`() {
        var balance = account.balance
        assertEquals(0.0, balance)
    }

    @Test
    fun `Deposit adds to balance`() {
        account.deposit(1000.00)
        var balance = account.balance
        assertEquals(1000.00, balance)
    }

    @Test
    fun `Withdrawal subtracts from balance`() {
        account.deposit(2000.00)
        account.withdraw(1000.00)
        var balance = account.balance
        assertEquals(1000.00, balance)
    }
    @Test
    fun `Withdrawing more than balance throws error`() {
        val exception = assertThrows <Exception> { account.withdraw(1000.00) }
        assertEquals("Insufficient funds available",exception.message)
    }

}