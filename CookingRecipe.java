

import java.util.*;

public class CookingRecipe {

    private String name;

    public ArrayList<RecipeIngredient> recipeIngredients = new ArrayList<RecipeIngredient>();

    CookingRecipe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void addOrUpdateRecipeIngredient(Ingredient ingredient, float quantity) {
        int c = 0;
        int d = 0;
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient.getName(), ingredient.getMeasuringUnit(), ingredient.getCaloriesPerUnit(), quantity);
        for (int i = 0; i < recipeIngredients.size(); i++) {
            if (recipeIngredient.getName().equals(recipeIngredients.get(i).getName())) {
                c++;
                d = i;
            }
        }
        if (c > 0)
            recipeIngredients.set(d, recipeIngredient);

        else
            recipeIngredients.add(recipeIngredient);
    }

    public RecipeIngredient[] getRecipeIngredient() {
        RecipeIngredient[] arr = new RecipeIngredient[recipeIngredients.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < recipeIngredients.size(); i++)
            arr[i] = recipeIngredients.get(i);

        return arr;
    }

    public RecipeIngredient getRecipeIngredient(Ingredient ingredient) {

        int c = position(ingredient.getName());

        RecipeIngredient obj = recipeIngredients.get(c);

        return obj;
    }


    public RecipeIngredient getRecipeIngredient(String ingredientName) {
        int c = 0;

        if (position(ingredientName) >= 0)
            c++;

        if (c == 1)
            return recipeIngredients.get(position(ingredientName));

        else
            return null;
    }

    public int position(String ingredientName) {
        int d = 0;
        for (int i = 0; i < recipeIngredients.size(); i++) {
            if (ingredientName.equals(recipeIngredients.get(i).getName())) {
                d = i;
                return d;
            }

        }
        return -1;
    }

    public RecipeIngredient removeRecipeIngredient(Ingredient ingredient) {

        int c = position(ingredient.getName());

        RecipeIngredient obj = recipeIngredients.get(c);

        recipeIngredients.remove(obj);

        return obj;
    }

    public RecipeIngredient removeRecipeIngredient(String ingredientName) {

        int c = 0;

        if (position(ingredientName) >= 0)
            c++;

        if (c == 1) {
            RecipeIngredient obj = recipeIngredients.get(position(ingredientName));
            recipeIngredients.remove(recipeIngredients.get(position(ingredientName)));
            return obj;
        } else
            return null;
    }

    public float calculateCalories() {
        float totalCalories = 0.0f;
        for (int i = 0; i < recipeIngredients.size(); i++) {
            totalCalories = totalCalories + recipeIngredients.get(i).getCaloriesPerUnit() * recipeIngredients.get(i).getQuantity();
        }
        return totalCalories;
    }

    public int getNumberOfIngredients() {
        return recipeIngredients.size();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < recipeIngredients.size(); i++) {
            s = s + recipeIngredients.get(i).getName() + " ";
        }
        return "Name of the recipe: " + getName() + " Ingredients: " + s;
    }


    public boolean equals(Object o) {
        if (o instanceof CookingRecipe) {
            name.equals(((CookingRecipe) o).getName());
        }
        return false;
    }
}
