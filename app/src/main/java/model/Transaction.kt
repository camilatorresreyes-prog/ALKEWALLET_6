package com.example.alkewallet_6.model

data class Transaction(
    val id: String,
    val date: String,
    val amount: Double,
    val description: String,
    val from: String,
    val to: String
)