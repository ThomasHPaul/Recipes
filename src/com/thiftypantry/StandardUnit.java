package com.thiftypantry;

import java.util.HashMap;
import java.util.Map;

public class StandardUnit {

    public static Map<String, StandardUnit> list;

    static {
        list = new HashMap<>();
        list.put("ml", new StandardUnit("ml", "milliliter", UnitType.VOLUME));
        list.put("l", new StandardUnit("l", "liter", UnitType.VOLUME));
        list.put("tsp", new StandardUnit("tsp", "tsp", UnitType.VOLUME));
        list.put("tbsp", new StandardUnit("tbsp", "tablespoon", UnitType.VOLUME));
        list.put("floz", new StandardUnit("floz", "fluid ounce", UnitType.VOLUME));
        list.put("c", new StandardUnit("c", "cup", UnitType.VOLUME));
        list.put("qt", new StandardUnit("qt", "quart", UnitType.VOLUME));
        list.put("pt", new StandardUnit("pt", "pint", UnitType.VOLUME));
        list.put("gal", new StandardUnit("gal", "gallon", UnitType.VOLUME));

        list.put("mg", new StandardUnit("mg", "milligram", UnitType.WEIGHT));
        list.put("g", new StandardUnit("g", "gram", UnitType.WEIGHT));
        list.put("kg", new StandardUnit("kg", "kilogram", UnitType.WEIGHT));
        list.put("oz", new StandardUnit("oz", "ounce", UnitType.WEIGHT));
        list.put("lb", new StandardUnit("lb", "pound", UnitType.WEIGHT));
    }

    private String abbreviation;
    private String fullName;
    private UnitType unitType;

    StandardUnit(String abbreviation, String fullName, UnitType unitType) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
        this.unitType = unitType;
    }

    public static void upsertMeasurement(String abbrev, String fullName, UnitType unitType) {
        if(fullName == null) {
            throw new IllegalArgumentException("Cannot have null value for unit fullName");
        }
        if(abbrev == null) {
            throw new IllegalArgumentException("Cannot have null value for unit abbreviation");
        }
        if(fullName.equals("")) {
            throw new IllegalArgumentException("Cannot have blank fullName for unit");
        }
        if(abbrev.equals("")) {
            throw new IllegalArgumentException("Cannot have blank unit abbreviation");
        }
        if(list.get(abbrev) != null) {
            throw new IllegalArgumentException("Measurement " + abbrev + " is already in StandardUnit.list");
        }

        list.put(abbrev, new StandardUnit(abbrev, fullName, unitType));
    }

    public static void removeMeasurement(String abbrev) {
        list.remove(abbrev);
    }

    public UnitType getUnitType() { return this.unitType; }

    public String getAbbreviation() { return abbreviation; }

    public String getFullName() { return fullName; }

    public static String getAbbreviationFromList(String abbrev) { return list.get(abbrev).getAbbreviation(); }

    public static String getFullName(String abbrev) { return list.get(abbrev).getFullName(); }

    public static StandardUnit getUnit(String abbrev) { return list.get(abbrev); }
}
