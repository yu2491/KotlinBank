import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import Transaction as Transaction

class BankStatementTest {

    class FakeCreditTransaction : Transaction {
        override fun getDate() = "16/02/2021"
        override fun getAmount() = "1000.00"
    }

    class FakeDebitTransaction : Transaction {
        override fun getDate() = "17/02/2021"
        override fun getAmount() = "250.00"
    }

    val subject = BankStatement()

    @Test
    fun `Returns just the header if no transactions are added`() {
        val statement = subject.getStatement()
        assertEquals("date || credit || debit || balance", statement)
    }

    @Test
    fun `Returns correct format for credit amount`() {
        val transaction = FakeCreditTransaction()
        subject.addCreditTransaction(transaction,2000.00)
        val expectedString = "date || credit || debit || balance\n16/02/2021 || 1000.00 || || 2000.00"
        val statement = subject.getStatement()
        assertEquals(expectedString,statement)
    }

    @Test
    fun `Returns correct format for debit amount`() {
        val transaction = FakeDebitTransaction()
        subject.addDebitTransaction(transaction,4000.00)
        val expectedString = "date || credit || debit || balance\n17/02/2021 || || 250.00 || 4000.00"
        val statement = subject.getStatement()
        assertEquals(expectedString,statement)
    }

    @Test
    fun `Returns correct format for two transactions`() {
        val transaction1 = FakeCreditTransaction()
        val transaction2 = FakeDebitTransaction()
        subject.addCreditTransaction(transaction1,1000.00)
        subject.addDebitTransaction(transaction2,750.00)
        val expectedString = "date || credit || debit || balance\n17/02/2021 || || 250.00 || 750.00\n16/02/2021 || 1000.00 || || 1000.00"
        val statement = subject.getStatement()
        assertEquals(expectedString,statement)
    }

}