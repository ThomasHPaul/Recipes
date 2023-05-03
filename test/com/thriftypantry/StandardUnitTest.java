package com.thriftypantry;

import com.thiftypantry.StandardUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StandardUnitTest {

    @Test
    public void mlStaticInitialized_UnitAvailableOutsideClassContext() {
        String mlFullName = StandardUnit.getFullName("ml");
        assertEquals("milliliter", mlFullName);
    }

    @Test
    public void callAddStandardUnitWithUnitPresent_ThrowError() {
        String abbrev = "ml";
        assertThrows(IllegalStateException.class,
                () ->StandardUnit.addMeasurement(abbrev, "milliliter"),
                "Measurement " + abbrev + " is already in StandardUnit.list");
    }
}
