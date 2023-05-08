package com.thriftypantry;

import com.thiftypantry.StandardUnit;
import com.thiftypantry.Step;
import com.thiftypantry.Units;
import org.junit.jupiter.api.Test;

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

    } //spaces, tabs, newlines
}
