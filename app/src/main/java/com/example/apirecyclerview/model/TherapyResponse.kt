package com.example.apirecyclerview.model

data class TherapyResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean,
    val token: String
)