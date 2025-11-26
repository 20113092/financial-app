package ie.setu

import ie.setu.models.*
import ie.setu.utils.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    while (true) {
    print("""
          ----------------------------------
          |        Financial App           |
          ----------------------------------
          | NOTE MENU                      |
          |   1) Add your Income           |
          |   2) Add your Expenses         |
          |   3) List All Incomes          |
          |   4) Report                    |  
          |   5) Exit                      |  
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
                    3 -> listAllIncomes()
                    4 -> report()
                    5 -> exit()
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


fun listAllIncomes() {
    if (incomes.isEmpty()) {
        println("No Incomes on Record.")
    } else {

        println("----------------------------------")
        println("|   All Your Recorded Incomes.   |")
        println("----------------------------------")

        incomes.forEach { println(it) }
    }
}

fun report() {}

fun exit() {}

