class BankStatement(private val transactions: MutableList<BankTransaction> = mutableListOf()) {

    private val header: String = "date || credit || debit || balance"


    fun getStatement(): String {
        return header + getTransactions()
    }

    fun addTransaction(transaction: BankTransaction) {
        transactions.add(transaction)
    }

    private fun getTransactions(): String {
        return transactions.map { transaction -> if(transaction.type == "credit")
            creditTransactionAsString(transaction) else debitTransactionAsString(transaction) }
            .asReversed().joinToString("")
    }

    private fun creditTransactionAsString(transaction: BankTransaction): String {
        return "\n${transaction.getDate()} || ${transaction.getAmount()} || || ${transaction.getBalance()}"
    }

    private fun debitTransactionAsString(transaction: BankTransaction): String {
        return "\n${transaction.getDate()} || || ${transaction.getAmount()} || ${transaction.getBalance()}"
    }
}