package com.example.mangetout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mangetout.ui.theme.MangetoutTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


data class Recipe(
    val id: Int,
    val title: String,
    //val image: Int,
//    val ingredients: List<String>,
//    val instructions:String
)

val recipes = listOf(
    Recipe(
    1,
        "How to boil an egg",


    ),
    Recipe(
        2,
        "Village Lentils",
        ),
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MangetoutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    App()
                }
            }
        }
    }

}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "recipeList"
    ) {
        composable("recipeList"){
            RecipeListScreen(
                recipes = recipes,
                onRecipeClick = {recipe ->
                    navController.navigate("recipeDetail/${recipe.id}")
                }
            )
        }

        composable("recipeDetail/{recipeId}"){backStackEntry ->
            val recipeId = backStackEntry.arguments
                ?.getString("recipeId")
                ?.toIntOrNull()

            val recipe = recipes.find{it.id == recipeId}

            if (recipe != null){
                RecipeDetailsScreen(recipe = recipe)
            }

        }

    }
}

@Composable
fun RecipeListScreen(
    recipes: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit
) {
    LazyColumn {
        items(recipes) { recipe ->
            Text(
                text = recipe.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onRecipeClick(recipe) }
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun RecipeDetailsScreen(recipe: Recipe) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = recipe.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Ingredients")



        Spacer(modifier = Modifier.height(16.dp))

        Text("Instructions")

    }
}
