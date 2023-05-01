package com.thiftypantry;

public enum StandardUnits {
    MILLILITER("ml", "milliliter"),
    LITER("l", "liter"),
    TEASPOON("tsp", "teaspoon"),
    TABLESPOON("tbsp", "tablespoon"),
    FLUID_OUNCE("fl oz", "fluid ounce"),
    QUART("qt", "quart"),
    GALLON("gal", "gallon"),
    PINT("pt", "pint"),
    CUP("c", "cup");

    private String abbreviation;
    private String fullName;

    StandardUnits(String abbreviation, String fullName) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getFullName() { return fullName; }
}
