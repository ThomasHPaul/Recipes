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

        assertEquals(960, ingredient.getAmount());
    }
}
