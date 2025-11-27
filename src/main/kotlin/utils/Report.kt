package ie.setu.utils

import ie.setu.controllers.FinanceAPI
import java.time.LocalDate

fun getTotalIncome(api: FinanceAPI): Double = api.getAllIncomes().sumOf { it.amount }

fun getTotalExpenses(api: FinanceAPI): Double = api.getAllExpenses().sumOf { it.amount }

fun getBalance(api: FinanceAPI): Double = getTotalIncome(api) - getTotalExpenses(api)

fun getIncomeByDateRange(api: FinanceAPI, start: LocalDate, end: LocalDate): Double =
    api.getAllIncomes().filter { it.date in start..end }.sumOf { it.amount }

fun getExpensesByDateRange(api: FinanceAPI, start: LocalDate, end: LocalDate): Double =
    api.getAllExpenses().filter { it.date in start..end }.sumOf { it.amount }
