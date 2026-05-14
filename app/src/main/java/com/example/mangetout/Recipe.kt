package com.example.mangetout

data class Recipe(
    val id: Int,
    val title: String,
    val image: Int,
    val description: String,
    val prepTime: String,
    val cookTime: String,
    val servings: Int,
    val ingredients: List<String>,
    val method: List<String>
)