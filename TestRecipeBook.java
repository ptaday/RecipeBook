package Homework6_InheritanceAndPolymorphism;

public class TestRecipeBook {

    public static void main(String[] args) {


        Ingredient lettuce = new Ingredient("Lettuce", "100 grams", 20);
        Ingredient yogurt = new Ingredient("Yogurt", "100 grams", 110);
        Ingredient bun = new Ingredient("Bun", "bun", 75);
        Ingredient olives = new Ingredient("Olives", "25 grams", 35);
        Ingredient pickles = new Ingredient("Pickles", "25 grams", 45);
        Ingredient mayo = new Ingredient("Mayo", "12grams", 80);
        Ingredient milk=new Ingredient("Milk","250 ml",160);
        Ingredient dryPasta=new Ingredient("Dry Pasta","100 grams",180);
        Ingredient pizzaBase=new Ingredient("PizzaBase","1 base",500);
        Ingredient sandwichBread=new Ingredient("Sandwich Bread","1 slice",75);
        Ingredient cheese=new Ingredient("American Cheese"," 1 slice",110);
        Ingredient chicken=new Ingredient("Grilled Chicken","4oz",150);
        Ingredient potato=new Ingredient("Dry potato","100 grams",300);
        Ingredient oil=new Ingredient("Oil","1 tbsp",45);
        Ingredient ketchup=new Ingredient("Tomato Ketchup","12 grams",55);


        CookingRecipe burger = new CookingRecipe("Burger");

        burger.addOrUpdateRecipeIngredient(lettuce, 1.0f);
        burger.addOrUpdateRecipeIngredient(yogurt, 1.0f);
        burger.addOrUpdateRecipeIngredient(bun, 1.0f);
        burger.addOrUpdateRecipeIngredient(lettuce, 5.0f);
        burger.addOrUpdateRecipeIngredient(bun, 2.0f);
        burger.addOrUpdateRecipeIngredient(olives, 1.0f);
        burger.addOrUpdateRecipeIngredient(pickles, 1.0f);
        burger.addOrUpdateRecipeIngredient(mayo, 1.0f);

        System.out.println(burger);

        System.out.println(burger.getRecipeIngredient(lettuce));

        System.out.println(burger.getRecipeIngredient("Olives"));
        System.out.println(burger.getRecipeIngredient("Beans"));


        System.out.println("The ingredient removed is " + burger.removeRecipeIngredient(yogurt).getName());

        System.out.println("The ingredient removed is " + burger.removeRecipeIngredient("Pickles").getName());

        System.out.println("Total Calories of the burger=" + burger.calculateCalories());

        System.out.println("Number of ingredients:" + burger.getNumberOfIngredients());

        System.out.println(burger);

        CookingRecipe pasta=new CookingRecipe("Pasta");

        pasta.addOrUpdateRecipeIngredient(dryPasta,2.0f);
        pasta.addOrUpdateRecipeIngredient(milk,1.0f);
        pasta.addOrUpdateRecipeIngredient(cheese,1.0f);
        pasta.addOrUpdateRecipeIngredient(olives,1.0f);
        pasta.addOrUpdateRecipeIngredient(cheese,2.0f);

        System.out.println(pasta);
        System.out.println("Calories in pasta:"+pasta.calculateCalories());


        CookingRecipe sandwich=new CookingRecipe("Sandwich");

        sandwich.addOrUpdateRecipeIngredient(sandwichBread,1.0f);
        sandwich.addOrUpdateRecipeIngredient(olives,1.0f);
        sandwich.addOrUpdateRecipeIngredient(cheese,1.0f);
        sandwich.addOrUpdateRecipeIngredient(chicken,1.0f);
        sandwich.addOrUpdateRecipeIngredient(sandwichBread,2.0f);
        sandwich.addOrUpdateRecipeIngredient(mayo,2.0f);

        System.out.println(sandwich);
        System.out.println("Calories in sandwich:"+sandwich.calculateCalories());


        CookingRecipe pizza=new CookingRecipe("Pizza");

        pizza.addOrUpdateRecipeIngredient(pizzaBase,1.0f);
        pizza.addOrUpdateRecipeIngredient(cheese,4.0f);
        pizza.addOrUpdateRecipeIngredient(olives,1.0f);
        pizza.addOrUpdateRecipeIngredient(pickles,2.0f);
        pizza.addOrUpdateRecipeIngredient(chicken,1.0f);
        pizza.addOrUpdateRecipeIngredient(ketchup,3.0f);
        pizza.addOrUpdateRecipeIngredient(mayo,2.0f);

        System.out.println(pizza);
        System.out.println("Calories in pizza:"+pizza.calculateCalories());

        CookingRecipe frenchFries=new CookingRecipe("French Fries");

        frenchFries.addOrUpdateRecipeIngredient(potato,4.0f);
        frenchFries.addOrUpdateRecipeIngredient(oil,8.0f);
        frenchFries.addOrUpdateRecipeIngredient(ketchup,2.0f);
        frenchFries.addOrUpdateRecipeIngredient(mayo,2.0f);

        System.out.println(frenchFries);
        System.out.println("Calories in french fries:"+frenchFries.calculateCalories());

        RecipeBook recipeBook = new RecipeBook("The Book Of Recipes");

        System.out.println(" Recipe Book - Page1--- " + recipeBook.addRecipe("Burger", burger.getRecipeIngredient()));

        System.out.println(" Recipe Book - Page2--- " + recipeBook.addRecipe("Pasta", pasta.getRecipeIngredient()));

        System.out.println(" Recipe Book - Page3--- " + recipeBook.addRecipe("Sandwich", sandwich.getRecipeIngredient()));

        System.out.println(" Recipe Book - Page4--- " + recipeBook.addRecipe("Pizza", pizza.getRecipeIngredient()));

        System.out.println(" Recipe Book - Page5--- " + recipeBook.addRecipe("French Fries",frenchFries.getRecipeIngredient()));


        System.out.println("Recipe removed:" + recipeBook.removeRecipe("Tofu"));

        System.out.println("Number of recipes with ingredients less than or equal to 5 is: " + recipeBook.findRecipesWithFewIngredients(5).length);

        System.out.println(" Recipe removed from Recipe Book: "+recipeBook.removeRecipe("French Fries"));

        System.out.println("Recipes with Low Calories:");

        CookingRecipe[] a=recipeBook.findRecipesLowCalories();


        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].getName());

        }


        RecipeIngredient[] recipeIngredients = { new RecipeIngredient("Mayo", "12grams", 80, 2.0f),new RecipeIngredient("Olives", "25 grams", 35,1),new RecipeIngredient("Grilled Chicken","4oz",150,1)};

        System.out.println("Recipes with mayo, olives and chicken as ingredients: ");


        CookingRecipe[] a1 = recipeBook.findRecipes(recipeIngredients);

        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i].getName());

        }

        System.out.println(recipeBook);


        Ingredient c=new RecipeIngredient("Pav","1 Bun",100,1);

        RecipeIngredient c1=new RecipeIngredient("Pav","1 Bun",100,1);

        System.out.println(c.equals(c1));
    }
}
