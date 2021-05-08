package com.example.markiiimark.kmm.shared.navigatin

sealed class Screen(
    val route: String,
){
    object RecipeList: Screen("recipeList")
    object RecipeDetail: Screen("recipeDetail")
}