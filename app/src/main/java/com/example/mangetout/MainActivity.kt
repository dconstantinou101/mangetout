package com.example.mangetout

import RecipeData.recipes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mangetout.ui.theme.MangetoutTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MangetoutTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
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

    Scaffold(
        containerColor = Color(0xFFF5F1E7),
        topBar = {
            MangetoutHeader()
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "recipeList",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("recipeList") {
                RecipeListScreen(
                    recipes = recipes,
                    onRecipeClick = { recipe ->
                        navController.navigate("recipeDetail/${recipe.id}")
                    }
                )
            }

            composable("recipeDetail/{recipeId}") { backStackEntry ->
                val recipeId = backStackEntry.arguments
                    ?.getString("recipeId")
                    ?.toIntOrNull()

                val recipe = recipes.find { it.id == recipeId }

                if (recipe != null) {
                    RecipeDetailsScreen(
                        recipe = recipe,
                        onBackClick = {
                            navController.popBackStack()
                         }
                    )
                }

            }

        }
    }
}


@Composable
fun MangetoutHeader(){
    Column{
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF5A8F2D))
                .statusBarsPadding()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ){
            Image(
                painter = painterResource(id=R.drawable.mangetour),
                contentDescription = "Mangetout Banner",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() }

    ){
        Column{
            Image(
                painter = painterResource(id = recipe.image),
                contentDescription = recipe.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = recipe.title,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }



}

@Composable
fun RecipeListScreen(
    recipes: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit
) {
    Column{


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {

            items(recipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        onRecipeClick(recipe)
                    }

                )
            }
        }
    }
}


@Composable
fun RecipeDetailsScreen(
    recipe: Recipe,
    onBackClick: ()-> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    )  {
        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF5A8F2D))
            ) {
                TextButton(
                    onClick = { onBackClick() },


                    ) {
                    Text(
                        text = "Back",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
        item {
            Image(
                painter = painterResource(id=recipe.image),
                contentDescription = recipe.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                contentScale = ContentScale.Crop
            )
        }
        item{
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ){
                Column(
                    modifier = Modifier
                        .padding(20.dp)) {
                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color(0xFF1B5E20)
                    )

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 20.dp)
                    )

                    Text(
                        text = "Ingredients",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF2E7D32)
                    )


                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.ingredients.forEach { ingredient ->
                        Text(
                            text = " $ingredient",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )

                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 20.dp)
                    )

                    Text(
                        text = "Method",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF2E7D32)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    recipe.method.forEach { step ->
                        Text(
                            text = " $step",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )

                    }
                }
            }
        }
    }



}
