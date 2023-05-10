package com.thiftypantry;

import java.util.*;

public class RecipeList {
    private ArrayList<Recipe> recipes = new ArrayList<>();

    private Map<String, Ingredient> ingredients = new HashMap<>();

    public RecipeList() {}

    public void add(Recipe recipe) {
        recipes.add(recipe);

        upsertIngredients(recipe);
    }

    public int getNumOfIngredients() {
        Set<String> ingredientList = new HashSet<>();

        for(Recipe recipe : recipes) {
            for(String ingredientName : recipe.getIngredientNames()) {
                ingredientList.add(ingredientName);
            }
        }

        return ingredientList.size();
    }

    public double getIngredientQty(String ingredientName) {
        double ingredientQty = 0.0d;

        for(Recipe recipe : recipes) {
            ingredientQty += recipe.getIngredientQty(ingredientName);
        }

        return ingredientQty;
    }

    private void upsertIngredients(Recipe recipe) {

        // foreach ingredient in recipe
            // check to see if ingredient in ingredientsMap
                //if yes, then add qty's together
                    //grab current ingredient qty from ingredientsMap (assume EVERYTHING already converted to commonUnit
                    //add current ingredient qty to oldIngredient qty from ingredientsMap
                    //put ingredient with new qty to ingredientsMap

                //if no, then add new Map entry with ingredient
        if()
        for(Ingredient ingredient : recipe.getIngredientList()) {
            String ingredientName = ingredient.getName();

            if(ingredients.containsKey(ingredientName)) {
                Units newUnits = recipe.getIngredient(ingredientName).getUnits();
                Units oldUnits = ingredients.get(ingredientName).getUnits();
                oldUnits.convert(oldUnits.getCommonUnit());
                newUnits.convert(newUnits.getCommonUnit());

                double newQty = oldUnits.getQty() + newUnits.getQty();

                Ingredient newIngredient = new Ingredient(ingredientName, new Units(newQty, newUnits.getCommonUnit()));

                ingredients.put(ingredientName, newIngredient);
            }
            else {
                ingredients.put(ingredientName, ingredient);
            }
        }
    }
}
