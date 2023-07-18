package Homework6_InheritanceAndPolymorphism;

import Homework5_ClassesAndObjects.Horse;

import java.util.ArrayList;

public class RecipeBook {

    private String bookName;

    public RecipeBook(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public ArrayList<CookingRecipe> cookingRecipes = new ArrayList<CookingRecipe>();

    public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients) {

        CookingRecipe cookingRecipe = new CookingRecipe(name);
        boolean check = false;
        int d = 0;
        for (int i = 0; i < cookingRecipes.size(); i++) {
            if (cookingRecipes.get(i).getName().equals(cookingRecipe.getName())) {
                check = true;
                d = i;

            }
        }

        if (check)
            return null;

        else {
            cookingRecipes.add(cookingRecipe);

            for(int i=0;i<ingredients.length;i++)
            {
                cookingRecipe.recipeIngredients.add(i,ingredients[i]);
            }

           return  cookingRecipe;

        }

    }

    public CookingRecipe removeRecipe(String name) {

          boolean check = false;
        int d = 0;
        for (int i = 0; i < cookingRecipes.size(); i++) {
            if (cookingRecipes.get(i).getName().equals(name)) {
                check = true;
                d=i;
                System.out.println("Position of the removed recipe:"+d);
            }
        }


        if (check){
            CookingRecipe obj=cookingRecipes.get(d);
            cookingRecipes.remove(d);
            return obj;
        }

        else
            return null;

        }

    public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients) {
        ArrayList<CookingRecipe> tempCookingRecipes = new ArrayList<CookingRecipe>();
           int d=0;

        for (int i = 0; i < cookingRecipes.size(); i++) {
            int c = 0;
            for (int j = 0; j < cookingRecipes.get(i).getRecipeIngredient().length; j++) {
                for (int z = 0; z < ingredients.length; z++) {
                    if (cookingRecipes.get(i).getRecipeIngredient()[j].equals(ingredients[z]))
                        c++;
                }
            }
            if(c==ingredients.length){
                tempCookingRecipes.add(d,cookingRecipes.get(i));
                d++;
            }
        }
        CookingRecipe[] array=getCookingRecipe(tempCookingRecipes);
        return array;
    }

    public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients)
    {
        ArrayList<CookingRecipe> tempCookingRecipes = new ArrayList<CookingRecipe>();

        int c=0;
           CookingRecipe[] array=getCookingRecipe(cookingRecipes);

           for(int i=0;i<array.length;i++){
               if(array[i].getNumberOfIngredients()<=numberOfIngredients){
                   tempCookingRecipes.add(c,array[i]);
                   c++;
               }
           }
           array=getCookingRecipe(tempCookingRecipes);

           return array;

    }

    public CookingRecipe[] findRecipesLowCalories() {
        ArrayList<CookingRecipe> tempCookingRecipes = new ArrayList<CookingRecipe>();


        int c = 0;
        CookingRecipe[] array = getCookingRecipe(cookingRecipes);
        CookingRecipe[] temp1= new CookingRecipe[1];
        CookingRecipe[] temp2= new CookingRecipe[2];
        CookingRecipe[] temp3= new CookingRecipe[3];
        CookingRecipe[] temp4= new CookingRecipe[4];


        ArrayList<Float> calorieList = new ArrayList<Float>();

        for (int i = 0; i < cookingRecipes.size(); i++) {
            calorieList.add(i, cookingRecipes.get(i).calculateCalories());
        }

        float[] list = new float[calorieList.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < calorieList.size(); i++)
            list[i] = calorieList.get(i);

        java.util.Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            int d = 0;
            for(int j=0;j<cookingRecipes.size();j++){
            if (cookingRecipes.get(j).calculateCalories() == list[i]) {
                d = j;
                tempCookingRecipes.add(i, cookingRecipes.get(d));
                c++;
            }
            }
        }


        if (cookingRecipes.size() == 0) {
            System.out.println("No recipes in the recipe book.");
            return array;
        } else if (cookingRecipes.size() == 1) {
            return array;
        }
//less than 5 dishes it will return 1 dish as the lowest
        else if (cookingRecipes.size() <= 3&&cookingRecipes.size() > 1) {
            temp1[0]=tempCookingRecipes.get(0);
            return temp1;
        }
        else if(cookingRecipes.size() <= 6&&cookingRecipes.size() > 3){
            temp2[0]=tempCookingRecipes.get(0);
            temp2[1]=tempCookingRecipes.get(1);
            return temp2;
        }

        else if(cookingRecipes.size() <= 10&&cookingRecipes.size() > 6){
            temp3[0]=tempCookingRecipes.get(0);
            temp3[1]=tempCookingRecipes.get(1);
            temp3[2]=tempCookingRecipes.get(2);
            return temp3;
        }

        else
        {
            temp4[0]=tempCookingRecipes.get(0);
            temp4[1]=tempCookingRecipes.get(1);
            temp4[2]=tempCookingRecipes.get(2);
            temp4[3]=tempCookingRecipes.get(3);
            return temp4;
        }
    }

    public CookingRecipe[] getCookingRecipe(ArrayList<CookingRecipe>temp){
        CookingRecipe[] arr = new CookingRecipe[temp.size()];
        // ArrayList to Array Conversion
        for (int i = 0; i < temp.size(); i++)
            arr[i] = temp.get(i);

        return arr;
    }

    public String toString(){

        String s=" ";
        for(int i=0;i<cookingRecipes.size();i++){
            s=s+cookingRecipes.get(i).toString()+" ";
        }
        return "Recipe BookName: "+bookName+s;
    }

    public boolean equals(Object o){
        if(o instanceof RecipeBook){
            bookName.equals(((RecipeBook)o).getBookName());
        }
        return false;
    }
}

