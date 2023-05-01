package com.thriftypantry;

import com.thiftypantry.Ingredient;
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
        var units = new Units(3d, StandardUnits.TEASPOON);
        units.convert(StandardUnits.TABLESPOON);

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
}


