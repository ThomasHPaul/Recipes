package com.thiftypantry;

public enum StandardUnits {
    MILLILITER("ml"),
    LITER("l"),
    TEASPOON("tsp"),
    TABLESPOON("tbsp"),
    FLUID_OUNCE("fl oz"),
    QUART("qt"),
    GALLON("gal"),
    PINT("pt");

    private String abbreviation;

    StandardUnits(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
