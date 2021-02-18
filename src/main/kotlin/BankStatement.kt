class BankStatement {

    private val header: String = "date || credit || debit || balance"
    private var transactions: String = ""

    fun getStatement(): String {
        return header + transactions
    }

    fun addCreditTransaction(transaction: BankTransaction, balance: Double) {
        transactions = "\n${transaction.getDate()} || ${transaction.getAmount()} || || ${"%.2f".format(balance)}" + transactions
    }

    fun addDebitTransaction(transaction: BankTransaction, balance: Double) {
        transactions = "\n${transaction.getDate()} || || ${transaction.getAmount()} || ${"%.2f".format(balance)}" + transactions
    }
}