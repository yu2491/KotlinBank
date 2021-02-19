import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import java.util.*
import kotlin.test.assertEquals

class BankAccountTest {

    val date = mockk<LocalDate>()
    val statement = mockk<BankStatement>()
    val subject = BankAccount(statement = statement, date = date)

    @Test
    fun `Withdrawing more than balance throws error`() {
        val exception = assertThrows <Exception> { subject.withdraw(1000.00) }
        assertEquals("Insufficient funds available",exception.message)
    }

    @Test
    fun `Depositing adds a transaction to the statement`() {
        every { statement.addTransaction(any()) } just runs
        subject.deposit(1000.00)
        verify { statement.addTransaction(any()) }
    }

    @Test
    fun `Withdrawing adds a transaction to the statement`() {
        subject.balance = 1000.00
        every { statement.addTransaction(any()) } just runs
        subject.withdraw(250.00)
        verify { statement.addTransaction(any()) }
    }

    @Test
    fun `Printing calls getStatement() method from statement`() {
        every { statement.getStatement() } returns "Mock Statement"
        assertEquals("Mock Statement", subject.printStatement())
        verify { statement.getStatement() }
    }


}