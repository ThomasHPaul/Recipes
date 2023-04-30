package com.thriftypantry;

import com.thiftypantry.StandardUnits;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StandardUnitsTest {

    @ParameterizedTest
    @MethodSource("abbreviationTestProvider")
    public void standardUnitsGetAbbreviation_CorrectAbbreviationReturned(String correctAbbrev, StandardUnits units) {

    }

    private static Stream<Arguments> abbreviationTestProvider() {

    }
}
