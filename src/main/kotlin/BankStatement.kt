class BankStatement {

    val header = "date || credit || debit || balance"
    var transactions = ""

    fun getStatement(): String {
        return header + transactions
    }

    fun addCreditTransaction(transaction: Transaction, balance: Double) {
        transactions = "\n${transaction.getDate()} || ${transaction.getAmount()} || || ${"%.2f".format(balance)}" + transactions
    }
}