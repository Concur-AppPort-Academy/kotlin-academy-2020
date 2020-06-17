package com.concur.academy

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class Expense(
    var id: Int = Random.nextInt(1, 100),
    val amount: Float,
    val currency: Currency,
    val vendor: String
)

enum class Currency {
    CZK,
    USD,
    EUR
}
