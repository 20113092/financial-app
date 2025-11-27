package ie.setu.controllers

import ie.setu.models.Expense
import ie.setu.models.Income

class FinanceAPI {

    private val incomes = mutableListOf<Income>()
    private val expenses = mutableListOf<Expense>()

    fun addIncome(income: Income) {
        incomes.add(income)
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun getAllIncomes(): List<Income> = incomes
    fun getAllExpenses(): List<Expense> = expenses
}
