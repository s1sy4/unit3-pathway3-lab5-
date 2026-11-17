package com.example.thirtydays.data

/**
 * One card of the "30 days" challenge.
 *
 * @param day number from 1 to 30, also used as a stable key in the list
 * @param category short tag shown above the description
 */
data class Tip(
    val day: Int,
    val title: String,
    val description: String,
    val category: String,
)
