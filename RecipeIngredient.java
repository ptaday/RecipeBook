package Homework6_InheritanceAndPolymorphism;

public class RecipeIngredient extends Ingredient {

    private float quantity=0;

    public RecipeIngredient(String name, String measuringUnit, int caloriesPerUnit, float quantity)
    {
        super(name, measuringUnit, caloriesPerUnit);
        this.quantity=quantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity)
    {
        this.quantity=quantity;
    }


    public String toString(){
        return super.toString()+" Quantity:"+quantity;
    }
    public boolean equals(Object o) {

        if (o instanceof RecipeIngredient) {
            return quantity==(((RecipeIngredient) o).getQuantity())&& getName().equals(((RecipeIngredient) o).getName()) && getMeasuringUnit().equals(((Ingredient) o).getMeasuringUnit()) && (getCaloriesPerUnit() == ((Ingredient) o).getCaloriesPerUnit());

        }

        return false;
    }
}

