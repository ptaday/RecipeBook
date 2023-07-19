

import Homework5_ClassesAndObjects.Horse;

public class Ingredient {

    private String name;
    private String measuringUnit;
    private int caloriesPerUnit;



    Ingredient(String name, String measuringUnit, int caloriesPerUnit) {
        this.name = name;
        this.measuringUnit = measuringUnit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public int getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name:" + name + " Unit:" + measuringUnit + " Calories:" + caloriesPerUnit;
    }


    public boolean equals(Object o) {

        if (o instanceof Ingredient)
            return name.equals(((Ingredient) o).name) && measuringUnit.equals(((Ingredient) o).name) && (caloriesPerUnit == ((Ingredient) o).caloriesPerUnit);

        return false;
    }
}

