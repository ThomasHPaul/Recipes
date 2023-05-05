package com.thriftypantry;

import com.thiftypantry.Ingredient;
import com.thiftypantry.StandardUnit;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    public void createIngredient_VolumeUnitConvertedToCommonUnit() {
        var ingredient = ingredient("flour", 4, StandardUnit.list.get("c"));

        assertEquals(4.0, ingredient.getAmount());
    }

    @Test
    public void toStringCalledOnIngredientWithQtyNotEqualToOne_sAddedToEndOfIngredientName() {
        var ingredient = ingredient("onion", 0.5d, StandardUnit.list.get("c"));
        if(ingredient.getUnits().getQty() != 1d) {
            ingredient.makeNamePlural();
        }

        System.out.println(ingredient);
        assertEquals("0.5 cups onions", ingredient.toString());
    }

    private Ingredient ingredient(String name, double qty, StandardUnit units) {
        return new Ingredient(name, new Units(qty, units));
    }
}
