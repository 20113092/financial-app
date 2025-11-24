package ie.setu.models

import java.time.LocalDate

data class Income(
    var description: String,
    var category: String,
    var date: LocalDate,
    var amount: Double,
    val transferred: Boolean
)