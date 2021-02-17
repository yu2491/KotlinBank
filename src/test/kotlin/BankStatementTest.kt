import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BankStatementTest {

    val subject = BankStatement()
    val creditTransaction = mockk<BankTransaction>()
    val debitTransaction = mockk<BankTransaction>()

    @BeforeEach
    fun init() {
        every { creditTransaction.getDate() } returns "16/02/2021"
        every { creditTransaction.getAmount() } returns "1000.00"
        every { debitTransaction.getDate() } returns "17/02/2021"
        every { debitTransaction.getAmount() } returns "250.00"
    }

    @Test
    fun `Returns just the header if no transactions are added`() {
        val statement = subject.getStatement()
        assertEquals("date || credit || debit || balance", statement)
    }

    @Test
    fun `Returns correct format for credit amount`() {
        subject.addCreditTransaction(creditTransaction,2000.00)
        val expectedString = "date || credit || debit || balance\n16/02/2021 || 1000.00 || || 2000.00"
        assertEquals(expectedString,subject.getStatement())
    }

    @Test
    fun `Returns correct format for debit amount`() {
        subject.addDebitTransaction(debitTransaction,4000.00)
        val expectedString = "date || credit || debit || balance\n17/02/2021 || || 250.00 || 4000.00"
        assertEquals(expectedString,subject.getStatement())
    }

    @Test
    fun `Returns correct format for two transactions`() {
        subject.addCreditTransaction(creditTransaction,1000.00)
        subject.addDebitTransaction(debitTransaction,750.00)
        val expectedString = "date || credit || debit || balance\n17/02/2021 || || 250.00 || 750.00\n16/02/2021 || 1000.00 || || 1000.00"
        assertEquals(expectedString,subject.getStatement())
    }

}