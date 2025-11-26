package ie.setu.utils

fun getTotalIncome(): Double {
    return incomes.sumOf { it.amount}
}

fun getTotalExpenses(): Double {
    return expenses.sumOf { it.amount}
}

fun getBalance(): Double {
    return getTotalIncome() - getTotalExpenses()
}