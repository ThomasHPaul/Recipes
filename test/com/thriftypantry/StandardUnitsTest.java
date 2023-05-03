package com.thriftypantry;

import com.thiftypantry.StandardUnits;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardUnitsTest {

    @ParameterizedTest
    @MethodSource("abbreviationTestProvider")
    public void standardUnitsGetAbbreviation_CorrectAbbreviationReturned(String correctAbbrev, StandardUnits units) {
        assertEquals(correctAbbrev, units.getAbbreviation());
    }

    private static Stream<Arguments> abbreviationTestProvider() {
        return Stream.of(
                Arguments.of("tsp", StandardUnits.TEASPOON),
                Arguments.of("gal", StandardUnits.GALLON)
        );
    }

    @ParameterizedTest
    @MethodSource("fullNameTestProvider")
    public void standardUnitsFullName_CorrectNameReturned(String correctName, StandardUnits units) {
        assertEquals(correctName, units.getAbbreviation());
    }

    private static Stream<Arguments> fullNameTestProvider() {
        return Stream.of(
                Arguments.of("cup", StandardUnits.CUP),
                Arguments.of("fluid ounce", StandardUnits.FLUID_OUNCE),
                Arguments.of("quart", StandardUnits.QUART),
                Arguments.of("pint", StandardUnits.PINT),
                Arguments.of("liter", StandardUnits.LITER)
        );
    }

    @Test
    public void callAddStandardUnitWithUnitPresent_ThrowError() {

    }

    @Test
    public void callAddStandardUnitWithUnitMissing_StandardUnitUpdated () {

    }
}
