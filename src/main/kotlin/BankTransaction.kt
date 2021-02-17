import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BankTransaction(val type: String, val amount: Double, val date: LocalDate)  {

    fun getDate(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return date.format(formatter)
    }

    fun getAmount(): String {
        return "%.2f".format(amount)
    }

}
