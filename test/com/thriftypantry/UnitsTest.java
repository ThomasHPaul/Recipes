package com.thriftypantry;

import com.thiftypantry.StandardUnit;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitsTest {

    @ParameterizedTest
    @MethodSource("unitConversionArgumentProvider")
    public void convertFromCurrentUnitToNewUnit_CorrectQtyReturned(double expectedQty, Units unit, String convertTo) {
        Units units = unit;
        units.convert(StandardUnit.getUnit(convertTo));

        assertEquals(expectedQty,units.getQty());
    }

    private static Stream<Arguments> unitConversionArgumentProvider() {
        return Stream.of(
                Arguments.of(1, new Units(3d, StandardUnit.getUnit("tsp")), "tbsp"),
                Arguments.of(0.06, new Units(28d, StandardUnit.getUnit("g")), "lb"),
                Arguments.of(1287.04, new Units(0.34d, StandardUnit.getUnit("gal")), "ml")
        );
    }

    @Test
    public void initializeUnitsWithZeroOrNegativeQty_throwError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Units(-2.1d, StandardUnit.getUnit("tsp")),
                "Cannot create Units object with qty <= 0"); // No negative qty

        assertThrows(IllegalArgumentException.class,
                () -> new Units(0d, StandardUnit.getUnit("tsp")),
                "Cannot create Units object with qty <= 0"); // No zero qty
    }

    @Test
    public void toStringCalledOnUnitsWithQtyNotEqualToOne_sAddedToEndOfUnitName() {
        var units = new Units(0.5d, StandardUnit.getUnit("c"));

        assertEquals("0.5 cups", units.toString());
    }

    @Test
    public void conversionMissingInConversionTableConvertCalled_InvalidArgumentExceptionReturned() {
        var units = new Units(5d, StandardUnit.getUnit("tsp"));

        assertThrows(IllegalArgumentException.class,
                () -> units.convert(StandardUnit.getUnit("lb")),
                "Conversion not present on unitConversionTable");
    }
}


