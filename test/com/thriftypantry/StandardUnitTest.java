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
    public void callAddStandardUnitWithUnitAlreadyPresent_ThrowError() {
        String abbrev = "ml";
        assertThrows(IllegalArgumentException.class,
                () ->StandardUnit.upsertMeasurement(abbrev, "milliliter"),
                "Measurement " + abbrev + " is already in StandardUnit.list");
    }

    @Test
    public void callAddStandardUnitWithEmptyAbbreviation_ThrowError() {
        String abbrev = "";
        assertThrows(IllegalArgumentException.class,
                () ->StandardUnit.upsertMeasurement(abbrev, "Not Empty"),
                "Cannot have blank unit abbreviation");
    }

    @Test
    public void callAddStandardUnitWithEmptyFullName_ThrowError() {
        String fullName = "";
        assertThrows(IllegalArgumentException.class,
                () ->StandardUnit.upsertMeasurement("Not empty", fullName),
                "Cannot have blank fullName for unit");
    }

    @Test void callAddStandardUnitWithNullAbbreviation_ThrowError() {
        assertThrows(IllegalArgumentException.class,
                () ->StandardUnit.upsertMeasurement(null, "not null"),
                "Cannot have null value for unit abbreviation");
    }

    @Test void callAddStandardUnitWithNullFullName_ThrowError() {
        assertThrows(IllegalArgumentException.class,
                () ->StandardUnit.upsertMeasurement("not null", null),
                "Cannot have null value for unit fullName");
    }
}
