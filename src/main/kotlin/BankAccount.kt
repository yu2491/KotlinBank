class BankAccount {

    var balance: Double = 0.0

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if (amount > balance) throw Exception("Insufficient funds available")
        balance -= amount
    }

}
