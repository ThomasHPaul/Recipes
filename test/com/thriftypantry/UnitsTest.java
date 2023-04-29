package com.thriftypantry;

import com.thiftypantry.StandardUnits;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitsTest {

    @Test
    public void fromTspToTbl() {
        var units = new Units(3d, StandardUnits.TEASPOON);

        assertEquals(1, units.convert(StandardUnits.TABLESPOON));
    }
}


