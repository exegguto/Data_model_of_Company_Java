package com.example.data

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val name: String,
    val activity: Activity,
    val description: String,
    val contacts: String,
    var vacancies: Int
)

val company = mutableListOf<Company>(
    Company("OOO SuperPay", Activity.Banking, "123", "+791234567890", 2),
    Company("OOO \"Kotlin\"", Activity.Banking, "123", "+791234567890", 2),
    Company("OOO \"Pay\"", Activity.Banking, "123", "+791234567890", 2),
    Company("OOO \"Supe\"", Activity.PublicServices, "123", "+791234567890", 2),
    Company("OOO \"SuperPay1\"", Activity.Banking, "123", "+791234567890", 2),
    Company("OOO \"Kotlin1\"", Activity.Banking, "123", "+791234567890", 2),
    Company("OOO \"Pay1\"", Activity.Banking, "123", "+791234567890", 2),
    Company("OOO \"Supe1\"", Activity.PublicServices, "123", "+791234567890", 2),
    Company("OOO \"Pay2\"", Activity.Banking, "123", "+791234567890", 2),
    Company("OOO \"Supe2\"", Activity.PublicServices, "123", "+791234567890", 2)
)

val customerStorage = company
