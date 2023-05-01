package com.thiftypantry;

public class Ingredient {
    private String name;
    private Units units;

    public Ingredient(String name, Units units) {
        this.name = name;
        this.units = units;
    }

    private void convertToBaseUnit() {
        StandardUnits currentUnits = units.getStandardUnit();
        if(currentUnits != Units.commonVolumeUnit) {
            units.convert(Units.commonVolumeUnit);
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
