package com.thiftypantry;


import java.util.ArrayList;

public class Recipe {

    private int number;
    private String name;
    private ArrayList<Step> stepList;
    private ArrayList<Ingredient> ingredientList;
    private String url;

    public Recipe(int number, String name, ArrayList<Step> stepList, ArrayList<Ingredient> ingredientList, String url) {
        this.number = number;
        this.name = name;
        this.stepList = stepList;
        this.ingredientList = ingredientList;
        this.url = url;
    }

    public Recipe(int number, String name, ArrayList<Step> stepList, ArrayList<Ingredient> ingredientList) {
        this.number = number;
        this.name = name;
        this.stepList = stepList;
        this.ingredientList = ingredientList;
    }
}
