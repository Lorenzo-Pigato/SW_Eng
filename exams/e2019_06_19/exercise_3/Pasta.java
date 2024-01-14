package exams.e2019_06_19.exercise_3;

import java.util.Arrays;
import java.util.List;

public class Pasta implements Food{
    private String ingredients = "Pasta ";

    @Override
    public double cost() {
        return 5.00;
    }

    @Override
    public String getIngredients() {
        return ingredients;
    }

    public static void main(String[] args) {
        Food dish = new Cream(new Pesto(new Pasta()));
        
        List<String> ingredients = Arrays.asList(dish.getIngredients().split(" "));
        System.out.println(ingredients.contains("pesto") && ingredients.contains("cream") ? "Can't prepare this dish" : "Ingredients: " + dish.getIngredients() + " Price: " + dish.cost());
    }
}
