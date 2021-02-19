import java.time.LocalDate

class BankAccount(
    var balance: Double = 0.0,
    var statement: BankStatement = BankStatement(),
    var date: LocalDate = LocalDate.now()
) {

    fun deposit(amount: Double) {
        balance += amount
        val transaction = BankTransaction("credit", amount, date, balance)
        statement.addTransaction(transaction)
    }

    fun withdraw(amount: Double) {
        if (amount > balance) {
            throw Exception("Insufficient funds available")
        } else {
            balance -= amount
            val transaction = BankTransaction("debit", amount, date, balance)
            statement.addTransaction(transaction)
        }
    }

    fun printStatement(): String {
        println(statement.getStatement())
        return statement.getStatement()
    }

}
