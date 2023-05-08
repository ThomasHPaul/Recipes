package com.thriftypantry;

import com.thiftypantry.StandardUnit;
import com.thiftypantry.Step;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StepTest {

    @Test
    public void tryInitializeStepWithNullNote_ThrowError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Step(1, null, 4),
                "Step.note cannot be null");
    }

    @Test
    public void tryInitializeStepWithBlankNote_ThrowError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Step(1, "", 4),
                "Step.note cannot be blank");
    }

    @Test
    public void tryInitializeStepWithWhiteSpaceNote_ThrowError() {
        String combined = "   \n\t\t   \n\n  \n \t \t \n ";

        assertThrows(IllegalArgumentException.class,
                () -> new Step(1, combined, 4),
                "Step.note cannot contain only whitespace (spaces, tabs, newlines)");
    }

    @Test
    public void tryInitializeWithStepNumberLessThanOne_ThrowError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Step(0, "test", 4),
                "Step.number cannot be less than 1");

        assertThrows(IllegalArgumentException.class,
                () -> new Step(-1, "test", 4),
                "Step.number cannot be less than 1");
    }

    @Test
    public void tryInitializeWithDurationLessThanOne_ThrowError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Step(1, "test", 0),
                "Step.durationInMinutes cannot be less than 1");

        assertThrows(IllegalArgumentException.class,
                () -> new Step(-1, "test", -1),
                "Step.durationInMinutes cannot be less than 1");
    }
}
