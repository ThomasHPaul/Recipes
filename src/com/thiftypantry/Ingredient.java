package com.thiftypantry;

public class Ingredient {
    private String name;
    private Units units;

    public Ingredient(String name, Units units) {
        this.name = name;
        this.units = units;
    }

    public void convertToBaseUnit() {
        StandardUnit currentUnits = units.getStandardUnit();
        if(currentUnits != units.getCommonUnit()) {
            units.convert(units.getCommonUnit());
        }
    }

    public double getAmount() { return units.getQty(); }

    @Override
    public String toString() {
        return units.toString() + " " + name;
    }

    public Units getUnits() { return units; }

    public void makeNamePlural() { name = name + "s"; }
}
