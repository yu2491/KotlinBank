import BankStatement as BankStatement

class BankAccount() {

    var balance: Double = 0.0
    val statement: BankStatement = BankStatement()

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if (amount > balance) {
            throw Exception("Insufficient funds available")
        } else {
            balance -= amount
        }
    }

}
