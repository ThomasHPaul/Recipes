package com.thriftypantry;

import com.thiftypantry.Ingredient;
import com.thiftypantry.StandardUnits;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    public void createIngredient_VolumeUnitConvertedToCommonUnit() {
        var ingredient = new Ingredient("flour", new Units(4, StandardUnits.CUP));

        assertEquals(4.0, ingredient.getAmount());
    }

    @Test
    public void toStringCalledOnIngredientWithQtyNotEqualToOne_sAddedToEndOfIngredientName() {
        var ingredient = ingredient("onion", 0.5d, StandardUnits.CUP);
        if(ingredient.getUnits().getQty() != 1d) {
            ingredient.makeNamePlural();
        }

        System.out.println(ingredient);
        assertEquals("0.5 cups onions", ingredient.toString());
    }

    private Ingredient ingredient(String name, double qty, StandardUnits units) {
        return new Ingredient(name, new Units(qty, units));
    }
}
