package com.thriftypantry;

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

        assertEquals(1, units.convert(StandardUnits.TABLESPOON));
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
    public void convertFromCurrentUnitToNonexistantUnit_throwError() {
        // this test may start out true given behavior of enum, test though to be sure.
        // if default behavior then can remove test
    }


}


