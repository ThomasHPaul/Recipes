package com.thriftypantry;

import com.thiftypantry.Ingredient;
import com.thiftypantry.StandardUnit;
import com.thiftypantry.Step;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RecipeListTest {

    @Test
    public void getAllIngredientsFromMultiRecipeList_MapOfIngredientsWithQuantitiesInBaseUnitReturned() {
        // Recipe 1: Braised Chicken
        //initiate stepList
        Step bcStep1 = new Step(1, "salt the chicken and dip in oil", 1);
        Step bcStep2 = new Step(2, "heat up skillet to medium on stove", 5);
        Step bcStep3 = new Step(3, "melt butter into skillet", 1);
        Step bcStep4 = new Step(4, "place chicken into skillet and cook for 5 minutes on each side", 10);

        ArrayList<Step> braisedChickenSteps = new ArrayList<>();
        braisedChickenSteps.add(bcStep1);
        braisedChickenSteps.add(bcStep2);
        braisedChickenSteps.add(bcStep3);
        braisedChickenSteps.add(bcStep4);

        //initiate ingredientList
        Ingredient bcIngredient1 = new Ingredient("chicken", new Units(4d, StandardUnit.getUnit("lb")));
        Ingredient bcIngredient2 = new Ingredient("salt", new Units(2d, StandardUnit.getUnit("tsp")));
        Ingredient bcIngredient3 = new Ingredient("butter", new Units(4d, StandardUnit.getUnit("tbsp")));
        Ingredient bcIngredient4 = new Ingredient("oil", new Units(2.5d, StandardUnit.getUnit("tbsp")));

        ArrayList<Ingredient> braisedChickenIngredients = new ArrayList<>();
        braisedChickenIngredients.add(bcIngredient1);
        braisedChickenIngredients.add(bcIngredient2);
        braisedChickenIngredients.add(bcIngredient3);
        braisedChickenIngredients.add(bcIngredient4);

        RecipeList recipeList = new RecipeList();
        recipeList.add(1, "Braised Chicken", braisedChickenSteps, braisedChickenIngredients, "pioneer mom website with original recipe");

        // Recipe 2: Spaghetti
        Step sStep1 = new Step(1, "place pot of water on stove and bring to boil", 15);
        Step sStep2 = new Step(2, "pour oil into pot to prevent noodles bunching up", 1);
        Step sStep3 = new Step(3, "place noodles into pot", 1);
        Step sStep4 = new Step(4, "cook noodles until desired tenderness is reached ~10 minutes", 10);
        Step sStep5 = new Step(5, "strain noodles and place back in pot", 2);
        Step sStep6 = new Step(6, "thaw meat of choice", 60);
        Step sStep7 = new Step(7, "place meat into skillet and cook until no pink visible", 8);
        Step sStep8 = new Step(8, "strain meat to remove grease", 1);
        Step sStep9 = new Step(9, "pour meat into pot", 1);
        Step sStep10 = new Step(10, "add sauce of choice and stir together", 1);

        ArrayList<Step> sChickenSteps = new ArrayList<>();
        braisedChickenSteps.add(sStep1);
        braisedChickenSteps.add(sStep2);
        braisedChickenSteps.add(sStep3);
        braisedChickenSteps.add(sStep4);
        braisedChickenSteps.add(sStep5);
        braisedChickenSteps.add(sStep6);
        braisedChickenSteps.add(sStep7);
        braisedChickenSteps.add(sStep8);
        braisedChickenSteps.add(sStep9);
        braisedChickenSteps.add(sStep10);

        //initiate ingredientList
        // TODO continue here
        Ingredient sIngredient1 = new Ingredient("chicken", new Units(4d, StandardUnit.getUnit("lb")));
        Ingredient sIngredient2 = new Ingredient("salt", new Units(2d, StandardUnit.getUnit("tsp")));
        Ingredient sIngredient3 = new Ingredient("butter", new Units(4d, StandardUnit.getUnit("tbsp")));
        Ingredient sIngredient4 = new Ingredient("oil", new Units(2.5d, StandardUnit.getUnit("tbsp")));

        ArrayList<Ingredient> braisedChickenIngredients = new ArrayList<>();
        braisedChickenIngredients.add(sIngredient1);
        braisedChickenIngredients.add(sIngredient2);
        braisedChickenIngredients.add(sIngredient3);
        braisedChickenIngredients.add(sIngredient4);

        RecipeList recipeList = new RecipeList();
        recipeList.add(1, "Braised Chicken", braisedChickenSteps, braisedChickenIngredients, "pioneer mom website with original recipe");
    }
}
