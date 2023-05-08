package com.thriftypantry;

import com.thiftypantry.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecipeTest {

    @Test
    public void tryInitializeEmptyDirectionList_ThrowError() {
        var notEmptyIngredientList = new ArrayList<Ingredient>();
        var ingredient = new Ingredient("onion", new Units(4.5, StandardUnit.getUnit("tsp")));
        notEmptyIngredientList.add(ingredient);

        assertThrows(IllegalArgumentException.class,
                () -> new Recipe(1, "test name", new ArrayList<Step>(), notEmptyIngredientList, "url"),
                "Recipe.directionList cannot be empty"
                );
    }

    @Test
    public void tryInitializeEmptyIngredientList_ThrowError() {

    }

    @Test
    public void tryInitializeDirectionListAsNull_ThrowError() {

    }

    @Test
    public void tryInitializeIngredientListAsNull_ThrowError() {

    }

    @Test
    public void tryInitializeRecipeWithNumberLessThanOne_ThrowError() {

    }

    @Test
    public void tryInitializeRecipeWithEmptyName_ThrowError() {

    }

    @Test
    public void tryInitializeRecipeWithNameAsNull_ThrowError() {

    }
}
