
package ie.setu.models

import java.time.LocalDate

data class Expense(
    var description: String,
    var category: String,
    var recipient: String,
    var date: LocalDate,
    var amount: Double,
    val transferred: Boolean
)
