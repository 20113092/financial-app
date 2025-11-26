package ie.setu.utils

import ie.setu.models.Expense

val expenses = mutableListOf<Expense>()

    fun addExpense(expense: Expense) = expenses.add(expense)