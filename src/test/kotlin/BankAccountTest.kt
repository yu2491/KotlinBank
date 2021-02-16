import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BankAccountTest {

    val account = BankAccount()

    @Test
    fun balanceIs0ToStart() {
        var balance = account.balance
        assertEquals(balance,0.0)
    }

}