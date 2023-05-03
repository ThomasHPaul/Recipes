package com.thiftypantry;

import java.util.HashMap;
import java.util.Map;

public class StandardUnit {

    public static Map<String, StandardUnit> list;

    static {
        list = new HashMap<>();
        list.put("ml", new StandardUnit("ml", "milliliter"));
        list.put("l", new StandardUnit("l", "liter"));
        list.put("tsp", new StandardUnit("tsp", "tsp"));
        list.put("tbsp", new StandardUnit("tbsp", "tablespoon"));
        list.put("floz", new StandardUnit("floz", "fluid ounce"));
        list.put("c", new StandardUnit("c", "cup"));
        list.put("qt", new StandardUnit("qt", "quart"));
        list.put("pt", new StandardUnit("pt", "pint"));
        list.put("gal", new StandardUnit("gal", "gallon"));

        // TODO: Add weight measurements & conversions
        // standardUnits.put(__ADD WEIGHTS__)
    }

    private String abbreviation;
    private String fullName;

    StandardUnit(String abbreviation, String fullName) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
    }

    public static void addMeasurement(String abbrev, String fullName) {
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

        list.put(abbrev, new StandardUnit(abbrev, fullName));
    }

    public static void removeMeasurement(String abbrev) {
        list.remove(abbrev);
    }

    public String getAbbreviation() { return abbreviation; }

    public String getFullName() { return fullName; }

    public static String getAbbreviationFromList(String abbrev) { return list.get(abbrev).getAbbreviation(); }

    public static String getFullName(String abbrev) { return list.get(abbrev).getFullName(); }

    public static void setAbbreviation(String abbrev, String newAbbrev) { list.get(abbrev).abbreviation = newAbbrev; }

    public static void setFullName(String abbrev, String fullName) { list.get(abbrev).fullName = fullName; }
}
