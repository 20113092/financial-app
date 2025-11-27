package ie.setu

import ie.setu.controllers.FinanceAPI
import ie.setu.models.*
import ie.setu.utils.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

private val api = FinanceAPI()
private val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    print("""
          ----------------------------------
          |         Financial App          |
          ----------------------------------
          |   1) Add your Income           |
          |   2) Add your Expenses         |
          |   3) List All Incomes          |
          |   4) List All Expenses         |
          |   5) Get A Financial Report    |  
          |   6) Exit                      |  
          ----------------------------------
         > """.trimIndent())

    return readlnOrNull()?.toIntOrNull() ?: -1
}

fun runMenu() {
    while (true) {
        when (mainMenu()) {
            1 -> addIncome()
            2 -> addExpense()
            3 -> listIncomes()
            4 -> listExpenses()
            5 -> report()
            6 -> exit()
            else -> println("Invalid option, choose again")
        }
    }
}

fun addIncome() {
    print("Description: ")
    val description = readln()

    print("Category: ")
    val category = readln()

    print("Date (DD-MM-YYYY): ")
    val date = LocalDate.parse(readln(), formatter)

    print("Amount: ")
    val amount = readln().toDouble()

    print("Transferred (true/false): ")
    val transferred = readln().toBoolean()

    api.addIncome(Income(description, category, date, amount, transferred))
    println("Income Added.")
}


fun addExpense() {
    print("Description: ")
    val description = readln()

    print("Category: ")
    val category = readln()

    print("Recipient: ")
    val recipient = readln()

    print("Date (DD-MM-YYYY): ")
    val date = LocalDate.parse(readln(), formatter)

    print("Amount: ")
    val amount = readln().toDouble()

    print("Transferred (true/false): ")
    val transferred = readln().toBoolean()

    api.addExpense(Expense(description, category, recipient, date, amount, transferred))
    println("Expense Added.")
}


fun listIncomes() {
    val incomes = api.getAllIncomes()

    if (incomes.isEmpty()) {
        println("No Incomes on Record.")
    } else {
        incomes.forEach { println(it) }
    }
}

fun listExpenses() {
    val expenses = api.getAllExpenses()

    if (expenses.isEmpty()) {
        println("No Expenses on Record.")
    } else {
        expenses.forEach { println(it) }
    }
}


fun report() {
    println("-------------------------------------")
    println("|      Your Financial Report        |")
    println("-------------------------------------")
    println("| 1. Report on All Records.         |")
    println("| 2. Report with a Date Range.      |")
    println("-------------------------------------")

    when (readln().toInt()) {
        1 -> fullReport()
        2 -> dateRangeReport()
        else -> println("Invalid option.")
    }
}

fun fullReport() {
    val totalIncome = getTotalIncome(api)
    val totalExpenses = getTotalExpenses(api)
    val balance = getBalance(api)

    println("-------------------------------------")
    println("| Total Income: €$totalIncome       |")
    println("| Total Expenses: €$totalExpenses  |")
    println("| Total Balance: €$balance         |")
    println("-------------------------------------")
}

fun dateRangeReport() {
    print("Enter START date (DD-MM-YYYY): ")
    val startDate = LocalDate.parse(readln(), formatter)

    print("Enter END date (DD-MM-YYYY): ")
    val endDate = LocalDate.parse(readln(), formatter)

    val totalIncome = getIncomeByDateRange(api, startDate, endDate)
    val totalExpenses = getExpensesByDateRange(api, startDate, endDate)
    val balance = totalIncome - totalExpenses

    println("-------------------------------------")
    println("|   Financial Report By Date Range  |")
    println("-------------------------------------")
    println("| Total Income: €$totalIncome       |")
    println("| Total Expenses: €$totalExpenses  |")
    println("| Total Balance: €$balance         |")
    println("-------------------------------------")
}

fun exit() {
    println("Thank you, Bye Now!")
    exitProcess(0)
}
