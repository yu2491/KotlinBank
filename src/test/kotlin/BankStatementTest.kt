import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import Transaction as Transaction

class BankStatementTest {

    class FakeTransaction : Transaction {
        override fun getDate() = "16/02/2021"
        override fun getAmount() = "1000.00"
    }

    val subject = BankStatement()

    @Test
    fun `Returns just the header if no transactions are added`() {
        val statement = subject.getStatement()
        assertEquals("date || credit || debit || balance", statement)
    }

    @Test
    fun `Returns correct format for credit amount`() {
        val transaction = FakeTransaction()
        subject.addCreditTransaction(transaction,2000.00)
        val expectedString = "date || credit || debit || balance\n16/02/2021 || 1000.00 || || 2000.00"
        val statement = subject.getStatement()
        assertEquals(expectedString,statement)
    }

    @Test
    fun `Returns correct format for debit amount`() {
        val transaction = FakeTransaction()
        subject.addDebitTransaction(transaction,4000.00)
        val expectedString = "date || credit || debit || balance\n16/02/2021 || || 1000.00 || 4000.00"
        val statement = subject.getStatement()
        assertEquals(expectedString,statement)
    }

}