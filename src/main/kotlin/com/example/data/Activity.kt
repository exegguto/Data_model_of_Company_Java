package com.example.data

import kotlinx.serialization.Serializable

@Serializable
sealed class Activity {
    val name: String
        get() = when (this) {
            is It -> "IT"
            is Banking -> "Banking"
            is PublicServices -> "Public services"
            is All -> "All"
        }

    @Serializable object It : Activity()
    @Serializable object Banking : Activity()
    @Serializable object PublicServices : Activity()

    object All : Activity(){
        const val size = 4

       override fun toString(): String {
            return "1. IT\n" +
                    "2. Banking\n" +
                    "3. Public services\n" +
                    "4. All"
        }
        fun setActivity(n: Int): Activity {
            return when (n) {
                1 -> It
                2 -> Banking
                3 -> PublicServices
                else -> All
            }
        }
    }


}