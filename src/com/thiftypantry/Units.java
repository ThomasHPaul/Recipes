package com.thiftypantry;

import java.util.HashMap;
import java.util.Map;

public class Units {

    private static final Map<String, Double> unitConversionTable = new HashMap<>();

    private StandardUnits unitsType;
    private double qty;

    public Units(double qty, StandardUnits unitsType) {
        if(qty <= 0) {
            throw new IllegalArgumentException("Cannot create Units object with qty <= 0");
        }
        loadHashMap();
        this.qty = qty;
        this.unitsType = unitsType;
    }

    public double convert(StandardUnits convertTo) {
        String conversion = unitsType.getAbbreviation() + "2" + convertTo.getAbbreviation();
        System.out.println(conversion);
        double newQty = Math.round(qty * unitConversionTable.get(conversion).doubleValue());

        return newQty;
    }

    private void loadHashMap() {
        unitConversionTable.put("ml2l",0.0001d);
        unitConversionTable.put("ml2tsp",0.2d);
        unitConversionTable.put("ml2tbsp",0.06762804d);
        unitConversionTable.put("ml2fl oz",0.03333333333d);
        unitConversionTable.put("ml2qt",0.001056688d);
        unitConversionTable.put("ml2gal",0.000264172d);
        unitConversionTable.put("ml2pt",0.002113376d);
        unitConversionTable.put("l2ml",1000d);
        unitConversionTable.put("l2tsp",202.8841d);
        unitConversionTable.put("l2tbsp",67.62804d);
        unitConversionTable.put("l2fl oz",33.81402d);
        unitConversionTable.put("l2qt",1.056688d);
        unitConversionTable.put("l2gal",0.264172d);
        unitConversionTable.put("l2pt",2.113376d);
        unitConversionTable.put("tsp2ml",5d);
        unitConversionTable.put("tsp2l",200d);
        unitConversionTable.put("tsp2tbsp",0.3333333d);
        unitConversionTable.put("tsp2fl oz",0.1666667d);
        unitConversionTable.put("tsp2qt",0.005208333d);
        unitConversionTable.put("tsp2gal",0.001302083d);
        unitConversionTable.put("tsp2pt",0.01041667d);
        unitConversionTable.put("tbsp2ml",15d);
        unitConversionTable.put("tbsp2l",0.01478676d);
        unitConversionTable.put("tbsp2tsp",3d);
        unitConversionTable.put("tbsp2fl oz",0.5d);
        unitConversionTable.put("tbsp2qt",0.015625d);
        unitConversionTable.put("tbsp2gal",0.00390625d);
        unitConversionTable.put("tbsp2pt",0.03125d);
        unitConversionTable.put("fl oz2ml",30d);
        unitConversionTable.put("fl oz2l",0.02957353d);
        unitConversionTable.put("fl oz2tsp",6d);
        unitConversionTable.put("fl oz2tbsp",2d);
        unitConversionTable.put("fl oz2qt",0.03125d);
        unitConversionTable.put("fl oz2gal",0.0078125d);
        unitConversionTable.put("fl oz2pt",0.0625d);
        unitConversionTable.put("qt2ml",946.353d);
        unitConversionTable.put("qt2l",0.946353d);
        unitConversionTable.put("qt2tsp",192d);
        unitConversionTable.put("qt2tbsp",64d);
        unitConversionTable.put("qt2fl oz",32d);
        unitConversionTable.put("qt2gal",0.25d);
        unitConversionTable.put("qt2pt",2d);
        unitConversionTable.put("gal2ml",3785.412d);
        unitConversionTable.put("gal2l",3.785412d);
        unitConversionTable.put("gal2tsp",768d);
        unitConversionTable.put("gal2tbsp",256d);
        unitConversionTable.put("gal2fl oz",128d);
        unitConversionTable.put("gal2qt",4d);
        unitConversionTable.put("gal2pt",8d);
        unitConversionTable.put("pt2ml",473.1765d);
        unitConversionTable.put("pt2l",0.4731765d);
        unitConversionTable.put("pt2tsp",96d);
        unitConversionTable.put("pt2tbsp",32d);
        unitConversionTable.put("pt2fl oz",16d);
        unitConversionTable.put("pt2qt",0.5d);
        unitConversionTable.put("pt2gal",0.125d);
    }
}
