package com.thriftypantry;

import com.thiftypantry.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecipeTest {

    @Test
    public void tryInitializeEmptyStepList_ThrowError() {
        var notEmptyIngredientList = new ArrayList<Ingredient>();
        var ingredient = new Ingredient("onion", new Units(4.5, StandardUnit.getUnit("tsp")));
        notEmptyIngredientList.add(ingredient);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, "test name", new ArrayList<Step>(), notEmptyIngredientList, "url"),
                "Recipe.stepList cannot be empty"
                );
    }

    @Test
    public void tryInitializeEmptyIngredientList_ThrowError() {
        var notEmptyStepList = new ArrayList<Step>();
        var step = new Step(1, "test note", 4);
        notEmptyStepList.add(step);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, "test name", notEmptyStepList, new ArrayList<Ingredient>(), "url"),
                "Recipe.ingredientList cannot be empty"
        );
    }

    @Test
    public void tryInitializeStepListAsNull_ThrowError() {
        var notEmptyIngredientList = new ArrayList<Ingredient>();
        var ingredient = new Ingredient("onion", new Units(4.5, StandardUnit.getUnit("tsp")));
        notEmptyIngredientList.add(ingredient);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, "test name", null, notEmptyIngredientList, "url"),
                "Recipe.stepList cannot be null"
        );
    }

    @Test
    public void tryInitializeIngredientListAsNull_ThrowError() {
        var notEmptyStepList = new ArrayList<Step>();
        var step = new Step(1, "test note", 4);
        notEmptyStepList.add(step);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, "test name", notEmptyStepList, null, "url"),
                "Recipe.ingredientList cannot be null"
        );
    }

    @Test
    public void tryInitializeRecipeWithNumberLessThanOne_ThrowError() {
        var notEmptyStepList = new ArrayList<Step>();
        var step = new Step(1, "test note", 4);
        notEmptyStepList.add(step);

        var notEmptyIngredientList = new ArrayList<Ingredient>();
        var ingredient = new Ingredient("onion", new Units(4.5, StandardUnit.getUnit("tsp")));
        notEmptyIngredientList.add(ingredient);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(0, "test name", notEmptyStepList, notEmptyIngredientList, "url"),
                "Recipe.number cannot be less than 1"
        );

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(-1, "test name", notEmptyStepList, notEmptyIngredientList, "url"),
                "Recipe.number cannot be less than 1"
        );
    }

    @Test
    public void tryInitializeRecipeWithEmptyName_ThrowError() {
        var notEmptyStepList = new ArrayList<Step>();
        var step = new Step(1, "test note", 4);
        notEmptyStepList.add(step);

        var notEmptyIngredientList = new ArrayList<Ingredient>();
        var ingredient = new Ingredient("onion", new Units(4.5, StandardUnit.getUnit("tsp")));
        notEmptyIngredientList.add(ingredient);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, "", notEmptyStepList, notEmptyIngredientList, "url"),
                "Recipe.name cannot be empty String"
        );
    }

    @Test
    public void tryInitializeRecipeWithNameAsNull_ThrowError() {
        var notEmptyStepList = new ArrayList<Step>();
        var step = new Step(1, "test note", 4);
        notEmptyStepList.add(step);

        var notEmptyIngredientList = new ArrayList<Ingredient>();
        var ingredient = new Ingredient("onion", new Units(4.5, StandardUnit.getUnit("tsp")));
        notEmptyIngredientList.add(ingredient);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, null, notEmptyStepList, notEmptyIngredientList, "url"),
                "Recipe.name cannot be null"
        );
    }

    @Test
    public void tryInitializeRecipeNameWithOnlyWhitespace_ThrowError() {
        var notEmptyStepList = new ArrayList<Step>();
        var step = new Step(1, "test note", 4);
        notEmptyStepList.add(step);

        var notEmptyIngredientList = new ArrayList<Ingredient>();
        var ingredient = new Ingredient("onion", new Units(4.5, StandardUnit.getUnit("tsp")));
        notEmptyIngredientList.add(ingredient);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, " \t\t \n\n\n      \n", notEmptyStepList, notEmptyIngredientList, "url"),
                "Recipe.name cannot contain only whitespace"
        );
    }
}
