package com.example.mangetout

import RecipeData.recipes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel


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
fun App(
    recipeViewModel: RecipeViewModel = viewModel()
){
    val navController = rememberNavController()
    val state = recipeViewModel.state

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
                    recipes = state.recipes,
                    onRecipeClick = { recipe ->
                        navController.navigate("recipeDetail/${recipe.id}")
                    },
                    onLikeClick = { recipe ->
                        recipeViewModel.toggleLike(recipe.id)

                    }
                )
            }

            composable("recipeDetail/{recipeId}") { backStackEntry ->
                val recipeId = backStackEntry.arguments
                    ?.getString("recipeId")
                    ?.toIntOrNull()

                val recipe = recipeId?.let{
                    recipeViewModel.getRecipeById(it)
                }

                if (recipe != null) {
                    RecipeDetailsScreen(
                        recipe = recipe,
                        onBackClick = {
                            navController.popBackStack()
                         },
                        onLikeClick = {
                            recipeViewModel.toggleLike(recipe.id)
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
    onClick: () -> Unit,
    onLikeClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }

    ){
        Column{
            Box {
                Image(
                    painter = painterResource(id = recipe.image),
                    contentDescription = recipe.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { onLikeClick() },
                    modifier = Modifier.align(Alignment.TopEnd)

                ) {
                    Icon(
                        imageVector =
                            if (recipe.isLiked) Icons.Filled.Favorite
                            else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Like",
                        tint = if (recipe.isLiked) Color.Red else Color.White
                    )
                }
            }

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
    onRecipeClick: (Recipe) -> Unit,
    onLikeClick: (Recipe) -> Unit
) {

    Column{

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),

        ) {

            items(recipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        onRecipeClick(recipe)
                    },
                    onLikeClick = {
                        onLikeClick(recipe)
                    }

                )
            }
        }
    }
}




@Composable
fun RecipeDetailsScreen(
    recipe: Recipe,
    onBackClick: ()-> Unit,
    onLikeClick: () -> Unit
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
                IconButton(
                    onClick = { onBackClick() },


                    ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        }
        item {

            Box {

                Image(
                    painter = painterResource(id = recipe.image),
                    contentDescription = recipe.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { onLikeClick() },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {

                    Icon(
                        imageVector =
                            if (recipe.isLiked)
                                Icons.Filled.Favorite
                            else
                                Icons.Outlined.FavoriteBorder,

                        contentDescription = "Like recipe",

                        tint =
                            if (recipe.isLiked)
                                Color.Red
                            else
                                Color.White
                    )
                }
            }
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

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Prep",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            Icon(
                                imageVector = Icons.Filled.Timer,
                                contentDescription = "Prep Time",
                                tint = Color(0xFF1B5E20)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = recipe.prepTime,
                                style = MaterialTheme.typography.bodySmall
                            )


                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Cook",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            Icon(
                                imageVector = Icons.Filled.Restaurant,
                                contentDescription = "Cook Time",
                                tint = Color(0xFF1B5E20)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = recipe.cookTime,
                                style = MaterialTheme.typography.bodySmall
                            )


                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Serves",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            Icon(
                                imageVector = Icons.Filled.People,
                                contentDescription = "Servings",
                                tint = Color(0xFF1B5E20)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = recipe.servings.toString(),
                                style = MaterialTheme.typography.bodySmall
                            )


                        }
                    }


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
