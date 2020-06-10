package com.concur.academy

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class Expense (
    val id: Int = Random.nextInt(1, 100),
    val amount: Float,
    val vendor: String,
    val currency: Currency
)

enum class Currency {
    CZK,
    EUR,
    USD
}
