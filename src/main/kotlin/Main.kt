package ie.setu


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
          |   3) List your Incomes Above   |
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
                    2 -> addExpenses()
                    3 -> addIncome()
                    4 -> addExpenses()
                    5 -> exit()
                    else -> println("Invalid option, Chose again")
                }
            } while (true)
        }


fun addIncome() {}

fun addExpenses() {}

fun listIncome() {}

fun report() {}

fun exit() {}

