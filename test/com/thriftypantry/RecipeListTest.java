package com.thriftypantry;

import com.thiftypantry.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeListTest {

    @Test
    public void recipesWithSimilarIngredients_CorrectQuantitiesInBaseUnitReturned() {

        RecipeList recipeList = new RecipeList();

        // Recipe 1: Braised Chicken
        //initiate stepList
        Step bcStep1 = new Step(1, "salt the chicken and dip in oil", 1);
        Step bcStep2 = new Step(2, "heat up skillet to medium on stove", 5);
        Step bcStep3 = new Step(3, "melt butter into skillet", 1);
        Step bcStep4 = new Step(4, "place chicken into skillet and cook for 5 minutes on each side", 10);

        ArrayList<Step> bcSteps = new ArrayList<>();
        bcSteps.add(bcStep1);
        bcSteps.add(bcStep2);
        bcSteps.add(bcStep3);
        bcSteps.add(bcStep4);

        //initiate ingredientList
        Ingredient bcIngredient1 = new Ingredient("chicken", new Units(4d, StandardUnit.getUnit("lb")));
        Ingredient bcIngredient2 = new Ingredient("salt", new Units(2d, StandardUnit.getUnit("tsp")));
        Ingredient bcIngredient3 = new Ingredient("butter", new Units(4d, StandardUnit.getUnit("tbsp")));
        Ingredient bcIngredient4 = new Ingredient("oil", new Units(2.5d, StandardUnit.getUnit("tbsp")));

        ArrayList<Ingredient> bcIngredients = new ArrayList<>();
        bcIngredients.add(bcIngredient1);
        bcIngredients.add(bcIngredient2);
        bcIngredients.add(bcIngredient3);
        bcIngredients.add(bcIngredient4);

        recipeList.add(new Recipe(1, "Braised Chicken", bcSteps, bcIngredients, "pioneer mom website with original recipe"));

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

        ArrayList<Step> sSteps = new ArrayList<>();
        sSteps.add(sStep1);
        sSteps.add(sStep2);
        sSteps.add(sStep3);
        sSteps.add(sStep4);
        sSteps.add(sStep5);
        sSteps.add(sStep6);
        sSteps.add(sStep7);
        sSteps.add(sStep8);
        sSteps.add(sStep9);
        sSteps.add(sStep10);

        Ingredient sIngredient1 = new Ingredient("spaghetti noodles", new Units(1d, StandardUnit.getUnit("lb")));
        Ingredient sIngredient2 = new Ingredient("red sauce", new Units(3d, StandardUnit.getUnit("c")));
        Ingredient sIngredient3 = new Ingredient("ground beef", new Units(1d, StandardUnit.getUnit("lb")));
        Ingredient sIngredient4 = new Ingredient("oil", new Units(9d, StandardUnit.getUnit("tsp")));

        ArrayList<Ingredient> sIngredients = new ArrayList<>();
        sIngredients.add(sIngredient1);
        sIngredients.add(sIngredient2);
        sIngredients.add(sIngredient3);
        sIngredients.add(sIngredient4);

        recipeList.add(new Recipe(1, "Spaghetti", sSteps, sIngredients, "easy recipe mom website"));

        int numOfIngredients = 7;
        double qtyOilInMl = 82.5d; // 2.5 tbsp + 9 tsp = 16.5 tsp -> 92.5 mL

        assertEquals(numOfIngredients, recipeList.getNumOfIngredients());

        assertEquals(qtyOilInMl, recipeList.getIngredientQty("oil"));
    }
}
