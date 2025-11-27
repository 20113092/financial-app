package ie.setu.utils

import java.time.LocalDate

fun getTotalIncome(): Double = incomes.sumOf { it.amount }

fun getTotalExpenses(): Double = expenses.sumOf { it.amount }

fun getBalance(): Double = getTotalIncome() - getTotalExpenses()

fun getIncomeByDateRange(start: LocalDate, end: LocalDate): Double =
    incomes.filter { it.date in start..end }.sumOf { it.amount }

fun getExpensesByDateRange(start: LocalDate, end: LocalDate): Double =
    expenses.filter { it.date in start..end }.sumOf { it.amount }
