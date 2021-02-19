import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BankTransaction(
    val type: String,
    private val amount: Double,
    private val date: LocalDate = LocalDate.now(),
    private val balance: Double)  {

    fun getDate(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return date.format(formatter)

    }

    fun getAmount(): String {
        return "%.2f".format(amount)
    }

    fun getBalance(): String {
        return "%.2f".format(balance)
    }

}
