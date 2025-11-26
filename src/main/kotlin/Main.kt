package ie.setu

import ie.setu.models.*
import ie.setu.utils.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    while (true) {
    print("""
          ----------------------------------
          |         Financial App          |
          ----------------------------------
          | NOTE MENU                      |
          |   1) Add your Income           |
          |   2) Add your Expenses         |
          |   3) List All Incomes          |
          |   4) List All Expenses         |
          |   5) Get A Financial Report    |  
          |   6) Exit                      |  
          ----------------------------------
         >""".trimMargin(">"))
        return readlnOrNull()?.toIntOrNull() ?: -1
    }
}
        fun runMenu() {
            do {
                val option = mainMenu()
                when (option) {
                    1 -> addIncome()
                    2 -> addExpense()
                    3 -> listIncomes()
                    4 -> listExpenses()
                    5 -> report()
                    6 -> exit()
                    else -> println("Invalid option, Chose again")
                }
            } while (true)
        }


fun addIncome() {
    print("Description: ");
    val description = readln()

    print("Category: ");
    val category = readln()

    print("Date (DD-MM-YYYY): ");
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val date = LocalDate.parse(readln(), formatter)

    print("Amount: ");
    val amount = readln().toDouble()

    print("Transferred: (True/False): ");
    val transferred = readln().toBoolean()

    addIncome(Income(description, category, date, amount, transferred))
    println("Income complete.")
}

fun addExpense() {
    print("Description: ");
    val description = readln()

    print("Category: ");
    val category = readln()

    print("Recipient: ");
    val recipient = readln()

    print("Date (DD-MM-YYYY): ");
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val date = LocalDate.parse(readln(), formatter)

    print("Amount: ");
    val amount = readln().toDouble()

    print("Transferred: (True/False): ");
    val transferred = readln().toBoolean()

    addExpense(Expense(description, category, recipient, date, amount, transferred))
    println("Expense Added.")
}


fun listIncomes() {
    if (incomes.isEmpty()) {
        println("No Incomes on Record.")
    } else {

        println("----------------------------------")
        println("|   All Your Recorded Incomes.   |")
        println("----------------------------------")

        incomes.forEach { println(it) }
    }
}

fun listExpenses() {
    if (expenses.isEmpty()) {
        println("No Expenses on Record.")
    } else {

        println("----------------------------------")
        println("|   All Your Recorded Expenses.  |")
        println("----------------------------------")

        expenses.forEach { println(it) }
    }
}

fun report() {
    val totalIncome = incomes.sumOf { it.amount }
    val totalExpenses = expenses.sumOf { it.amount }
    val balance = totalIncome - totalExpenses
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val formattedDate = today.format(formatter)

    println("-------------------------------------")
    println("|      Your Financial Report        |")
    println("-------------------------------------")
    println("|Report Generated on: $formattedDate    |")
    println("-------------------------------------")
    println("|Total Income: $totalIncome             |")
    println("|Total Expenses: $totalExpenses         |")
    println("-------------------------------------")
    println("|Total Balance: €$balance               |")
    println("-------------------------------------")

}

fun exit() {
    println("Thank you, Bye Now!")
    exitProcess(0)
}

