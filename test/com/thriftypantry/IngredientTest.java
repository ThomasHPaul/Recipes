package com.thriftypantry;

import com.thiftypantry.Ingredient;
import com.thiftypantry.StandardUnit;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

        assertEquals("0.5 cups onions", ingredient.toString());
    }

    @ParameterizedTest
    @MethodSource("convertVolumeWeightProvider")
    public void convertToBaseUnitCalled_ConvertAbleToDistinguishVolumeAndWeight(double correctAmount, Ingredient ingredient) {
        ingredient.convertToBaseUnit();
        assertEquals(correctAmount, ingredient.getAmount());
    }

    private static Stream<Arguments> convertVolumeWeightProvider() {
        return Stream.of(
                Arguments.of(7.5d, ingredient("turmeric", 1.5d, StandardUnit.getUnit("tsp"))),
                Arguments.of(0.5d, ingredient("butter", 500.0d, StandardUnit.getUnit("mg"))),
                Arguments.of(1080.0d, ingredient("brown sugar", 4.5d, StandardUnit.getUnit("c")))
        );
    }

    private static Ingredient ingredient(String name, double qty, StandardUnit units) {
        return new Ingredient(name, new Units(qty, units));
    }
}
