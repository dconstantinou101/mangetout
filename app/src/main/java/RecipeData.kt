import com.example.mangetout.R
import com.example.mangetout.Recipe

object RecipeData {
    val recipes = listOf(

        Recipe(
            id = 1,
            title = "Creamy Garlic Pasta",
            image = R.drawable.egg,
            description = "A rich and creamy garlic pasta perfect for weeknight dinners.",
            prepTime = "10 mins",
            cookTime = "20 mins",
            servings = 2,
            ingredients = listOf(
                "200g pasta",
                "2 garlic cloves",
                "150ml double cream",
                "Parmesan cheese",
                "Salt",
                "Black pepper"
            ),
            method = listOf(
                "Boil the pasta until al dente.",
                "Cook garlic in olive oil.",
                "Add cream and parmesan.",
                "Mix with pasta and season to taste."
            )
        ),

        Recipe(
            id = 2,
            title = "Chicken Stir Fry",
            image = R.drawable.village_lentils,
            description = "Fresh vegetables and chicken tossed in a savoury sauce.",
            prepTime = "15 mins",
            cookTime = "15 mins",
            servings = 4,
            ingredients = listOf(
                "2 chicken breasts",
                "Broccoli",
                "Bell peppers",
                "Soy sauce",
                "Garlic",
                "Noodles"
            ),
            method = listOf(
                "Slice the chicken and vegetables.",
                "Cook chicken until golden.",
                "Add vegetables and stir fry.",
                "Add sauce and noodles."
            )
        ),

        Recipe(
            id = 3,
            title = "Tomato Basil Soup",
            image = R.drawable.egg,
            description = "Comforting tomato soup with fresh basil.",
            prepTime = "10 mins",
            cookTime = "30 mins",
            servings = 4,
            ingredients = listOf(
                "Tomatoes",
                "Onion",
                "Garlic",
                "Vegetable stock",
                "Fresh basil"
            ),
            method = listOf(
                "Cook onion and garlic.",
                "Add tomatoes and stock.",
                "Simmer for 25 minutes.",
                "Blend and add basil."
            )
        ),

        Recipe(
            id = 4,
            title = "Vegetable Curry",
            image = R.drawable.village_lentils,
            description = "A warming curry packed with vegetables and spices.",
            prepTime = "15 mins",
            cookTime = "35 mins",
            servings = 4,
            ingredients = listOf(
                "Potatoes",
                "Carrots",
                "Coconut milk",
                "Curry paste",
                "Spinach"
            ),
            method = listOf(
                "Cook vegetables until soft.",
                "Add curry paste.",
                "Pour in coconut milk.",
                "Simmer and stir in spinach."
            )
        ),

        Recipe(
            id = 5,
            title = "Classic Pancakes",
            image = R.drawable.village_lentils,
            description = "Fluffy homemade pancakes for breakfast.",
            prepTime = "10 mins",
            cookTime = "15 mins",
            servings = 4,
            ingredients = listOf(
                "Flour",
                "Milk",
                "Eggs",
                "Butter",
                "Sugar"
            ),
            method = listOf(
                "Mix all ingredients into a batter.",
                "Heat a pan with butter.",
                "Pour batter into pan.",
                "Flip when bubbles appear."
            )
        ),

        Recipe(
            id = 6,
            title = "Beef Tacos",
            image = R.drawable.egg,
            description = "Mexican-inspired beef tacos with fresh toppings.",
            prepTime = "15 mins",
            cookTime = "20 mins",
            servings = 4,
            ingredients = listOf(
                "Minced beef",
                "Taco shells",
                "Lettuce",
                "Cheese",
                "Tomatoes"
            ),
            method = listOf(
                "Cook minced beef with seasoning.",
                "Prepare toppings.",
                "Fill taco shells.",
                "Serve immediately."
            )
        ),

        Recipe(
            id = 7,
            title = "Avocado Toast",
            image = R.drawable.village_lentils,
            description = "Simple and healthy avocado toast.",
            prepTime = "5 mins",
            cookTime = "5 mins",
            servings = 2,
            ingredients = listOf(
                "Bread",
                "Avocado",
                "Lemon juice",
                "Salt",
                "Pepper"
            ),
            method = listOf(
                "Toast the bread.",
                "Mash avocado with lemon juice.",
                "Spread on toast.",
                "Season and serve."
            )
        ),

        Recipe(
            id = 8,
            title = "Chocolate Brownies",
            image = R.drawable.egg,
            description = "Rich and gooey chocolate brownies.",
            prepTime = "15 mins",
            cookTime = "30 mins",
            servings = 8,
            ingredients = listOf(
                "Dark chocolate",
                "Butter",
                "Sugar",
                "Eggs",
                "Flour"
            ),
            method = listOf(
                "Melt chocolate and butter.",
                "Mix in sugar and eggs.",
                "Fold in flour.",
                "Bake until set."
            )
        ),

        Recipe(
            id = 9,
            title = "Greek Salad",
            image = R.drawable.village_lentils,
            description = "Fresh Mediterranean salad with feta cheese.",
            prepTime = "10 mins",
            cookTime = "0 mins",
            servings = 3,
            ingredients = listOf(
                "Tomatoes",
                "Cucumber",
                "Olives",
                "Feta cheese",
                "Olive oil"
            ),
            method = listOf(
                "Chop vegetables.",
                "Combine in a bowl.",
                "Add feta and olives.",
                "Drizzle with olive oil."
            )
        ),

        Recipe(
            id = 10,
            title = "Mushroom Risotto",
            image = R.drawable.egg,
            description = "Creamy mushroom risotto with parmesan.",
            prepTime = "10 mins",
            cookTime = "35 mins",
            servings = 4,
            ingredients = listOf(
                "Arborio rice",
                "Mushrooms",
                "Parmesan",
                "Vegetable stock",
                "Onion"
            ),
            method = listOf(
                "Cook onion and mushrooms.",
                "Add rice and stir.",
                "Gradually add stock.",
                "Finish with parmesan."
            )
        ),

        Recipe(
            id = 11,
            title = "Lemon Drizzle Cake",
            image = R.drawable.village_lentils,
            description = "Moist sponge cake with zesty lemon syrup.",
            prepTime = "20 mins",
            cookTime = "40 mins",
            servings = 8,
            ingredients = listOf(
                "Flour",
                "Butter",
                "Sugar",
                "Eggs",
                "Lemons"
            ),
            method = listOf(
                "Mix cake ingredients.",
                "Bake until golden.",
                "Prepare lemon syrup.",
                "Pour syrup over cake."
            )
        ),

        Recipe(
            id = 12,
            title = "Spaghetti Bolognese",
            image = R.drawable.egg,
            description = "Classic Italian pasta dish with rich meat sauce.",
            prepTime = "15 mins",
            cookTime = "45 mins",
            servings = 4,
            ingredients = listOf(
                "Spaghetti",
                "Minced beef",
                "Tomatoes",
                "Onion",
                "Garlic"
            ),
            method = listOf(
                "Cook onion and garlic.",
                "Brown the beef.",
                "Add tomatoes and simmer.",
                "Serve with spaghetti."
            )
        ),

        Recipe(
            id = 13,
            title = "Berry Smoothie",
            image = R.drawable.egg,
            description = "Refreshing smoothie packed with berries.",
            prepTime = "5 mins",
            cookTime = "0 mins",
            servings = 2,
            ingredients = listOf(
                "Mixed berries",
                "Banana",
                "Yoghurt",
                "Honey"
            ),
            method = listOf(
                "Add ingredients to blender.",
                "Blend until smooth.",
                "Serve chilled."
            )
        ),

        Recipe(
            id = 14,
            title = "Roast Chicken",
            image = R.drawable.egg,
            description = "Traditional roast chicken with crispy skin.",
            prepTime = "15 mins",
            cookTime = "1 hr 20 mins",
            servings = 6,
            ingredients = listOf(
                "Whole chicken",
                "Butter",
                "Garlic",
                "Rosemary",
                "Potatoes"
            ),
            method = listOf(
                "Season the chicken.",
                "Roast in oven.",
                "Add potatoes halfway through.",
                "Rest before serving."
            )
        ),

        Recipe(
            id = 15,
            title = "Veggie Pizza",
            image = R.drawable.village_lentils,
            description = "Homemade pizza topped with fresh vegetables.",
            prepTime = "20 mins",
            cookTime = "15 mins",
            servings = 4,
            ingredients = listOf(
                "Pizza dough",
                "Tomato sauce",
                "Mozzarella",
                "Peppers",
                "Mushrooms"
            ),
            method = listOf(
                "Roll out dough.",
                "Spread tomato sauce.",
                "Add toppings and cheese.",
                "Bake until crispy."
            )
        ),

        Recipe(
            id = 16,
            title = "Chicken Caesar Salad",
            image = R.drawable.egg,
            description = "Crisp salad with grilled chicken and parmesan.",
            prepTime = "15 mins",
            cookTime = "10 mins",
            servings = 2,
            ingredients = listOf(
                "Chicken breast",
                "Romaine lettuce",
                "Croutons",
                "Parmesan",
                "Caesar dressing"
            ),
            method = listOf(
                "Cook the chicken.",
                "Prepare salad ingredients.",
                "Slice chicken and combine.",
                "Add dressing before serving."
            )
        ),

        Recipe(
            id = 17,
            title = "Fish Pie",
            image = R.drawable.village_lentils,
            description = "Creamy fish pie topped with mashed potato.",
            prepTime = "20 mins",
            cookTime = "40 mins",
            servings = 4,
            ingredients = listOf(
                "White fish",
                "Potatoes",
                "Milk",
                "Butter",
                "Peas"
            ),
            method = listOf(
                "Cook potatoes and mash.",
                "Prepare creamy fish filling.",
                "Top with mashed potato.",
                "Bake until golden."
            )
        ),

        Recipe(
            id = 18,
            title = "Banana Bread",
            image = R.drawable.egg,
            description = "Soft and moist banana loaf cake.",
            prepTime = "15 mins",
            cookTime = "50 mins",
            servings = 8,
            ingredients = listOf(
                "Bananas",
                "Flour",
                "Sugar",
                "Butter",
                "Eggs"
            ),
            method = listOf(
                "Mash bananas.",
                "Mix ingredients together.",
                "Pour into loaf tin.",
                "Bake until cooked through."
            )
        ),

        Recipe(
            id = 19,
            title = "Thai Green Curry",
            image = R.drawable.egg,
            description = "Fragrant Thai curry with coconut milk.",
            prepTime = "15 mins",
            cookTime = "25 mins",
            servings = 4,
            ingredients = listOf(
                "Chicken",
                "Green curry paste",
                "Coconut milk",
                "Bamboo shoots",
                "Rice"
            ),
            method = listOf(
                "Cook curry paste.",
                "Add chicken and cook through.",
                "Pour in coconut milk.",
                "Serve with rice."
            )
        ),

        Recipe(
            id = 20,
            title = "Apple Crumble",
            image = R.drawable.village_lentils,
            description = "Classic British dessert with crunchy topping.",
            prepTime = "20 mins",
            cookTime = "35 mins",
            servings = 6,
            ingredients = listOf(
                "Apples",
                "Flour",
                "Butter",
                "Sugar",
                "Cinnamon"
            ),
            method = listOf(
                "Slice apples and place in dish.",
                "Prepare crumble topping.",
                "Sprinkle topping over apples.",
                "Bake until golden."
            )
        )
    )


}