import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BankStatementTest {

    private val subject = BankStatement()
    private val creditTransaction = mockk<BankTransaction> {
        every { getDate() } returns "16/02/2021"
        every { getAmount() } returns "1000.00"
        every { type } returns "credit"
        every { getBalance() } returns "1000.00"
    }
    private val debitTransaction = mockk<BankTransaction> {
        every { getDate() } returns "17/02/2021"
        every { getAmount() } returns "250.00"
        every { type } returns "debit"
        every { getBalance() } returns "750.00"
    }

    @Test
    fun `Returns just the header if no transactions are added`() {
        assertEquals("date || credit || debit || balance", subject.getStatement())
    }

    @Test
    fun `Returns correct format for credit amount`() {
        subject.addTransaction(creditTransaction)
        val expectedString = "date || credit || debit || balance\n16/02/2021 || 1000.00 || || 1000.00"
        assertEquals(expectedString,subject.getStatement())
    }

    @Test
    fun `Returns correct format for debit amount`() {
        subject.addTransaction(debitTransaction)
        val expectedString = "date || credit || debit || balance\n17/02/2021 || || 250.00 || 750.00"
        assertEquals(expectedString,subject.getStatement())
    }

    @Test
    fun `Returns correct format for two transactions`() {
        subject.addTransaction(creditTransaction)
        subject.addTransaction(debitTransaction)
        val expectedString = "date || credit || debit || balance\n17/02/2021 || || 250.00 || 750.00\n16/02/2021 || 1000.00 || || 1000.00"
        assertEquals(expectedString,subject.getStatement())
    }

}