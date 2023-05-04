package com.thriftypantry;

import com.thiftypantry.Ingredient;
import com.thiftypantry.StandardUnit;
import com.thiftypantry.StandardUnits;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitsTest {

    @Test // TODO change to parameterized tests with multiple conversions
    public void convertFromCurrentUnitToNewUnit_CorrectQtyReturned() {
        var units = new Units(3d, StandardUnit.list.get("tsp"));
        units.convert(StandardUnit.list.get("tbsp"));

        assertEquals(1,units.getQty());
    }

    @Test
    public void intializeUnitsWithZeroOrNegativeQty_throwError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Units(-2.1d, StandardUnits.TEASPOON),
                "Cannot create Units object with qty <= 0"); // No negative qty

        assertThrows(IllegalArgumentException.class,
                () -> new Units(0d, StandardUnits.TEASPOON),
                "Cannot create Units object with qty <= 0"); // No zero qty
    }

    @Test
    public void toStringCalledOnUnitsWithQtyNotEqualToOne_sAddedToEndOfUnitName() {
        var units = new Units(0.5d, StandardUnits.CUP);

        System.out.println(units);
        assertEquals("0.5 cups", units.toString());
    }

    @Test
    public void weightMissingInWeightConversionTable_InvalidArgumentExceptionReturned() {

    }

    @Test
    public void volumeMissingInVolumeConversionTable_InvalidArgumentExceptionReturned() {

    }

    @Test
    public void commonVolumeUnitChangedAndGetUnit_CorrectUnitReturned() {

    }

    @Test
    public void commonVolumeUnitChangedAndGetQty_CorrectQtyReturned() {

    }

    @Test
    public void commonWeightUnitChangedAndGetUnit_CorrectUnitReturned() {

    }
}


