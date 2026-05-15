package com.example.mangetout

import RecipeData.recipes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


data class RecipeState(
    val recipes: List<Recipe> = emptyList()
)


class RecipeViewModel : ViewModel() {
    var state by mutableStateOf(
        RecipeState(
            recipes = recipes
        )
    )
        //
    private set

    fun toggleLike(recipeId:Int) {
        state = state.copy(
            recipes = state.recipes.map {recipe ->
                if(recipe.id == recipeId) {
                    recipe.copy(isLiked = !recipe.isLiked)
                } else {
                    recipe
                }

            }
        )
    }

    fun getRecipeById(recipeId: Int): Recipe? {
        return state.recipes.find{recipe ->
            recipe.id == recipeId

        }
    }
}