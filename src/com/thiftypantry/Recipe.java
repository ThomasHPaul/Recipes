package com.thiftypantry;


import java.util.ArrayList;

public class Recipe {

    private int number;
    private String name;
    private ArrayList<Step> stepList;
    private ArrayList<Ingredient> ingredientList;
    private String url;

    public Recipe(int number, String name, ArrayList<Step> stepList, ArrayList<Ingredient> ingredientList, String url) {
        setNumber(number);
        setName(name);
        setRecipeSteps(stepList);
        setIngredientList(ingredientList);
        this.url = url;
    }

    public Recipe(int number, String name, ArrayList<Step> stepList, ArrayList<Ingredient> ingredientList) {
        this.number = number;
        this.name = name;
        this.stepList = stepList;
        this.ingredientList = ingredientList;
    }

    public void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Recipe.name cannot be null");
        }
        if(name.equals("")) {
            throw new IllegalArgumentException("Recipe.name cannot be empty String");
        }
        if(name.trim().equals("")) {
            throw new IllegalArgumentException("Recipe.name cannot contain only whitespace");
        }

        this.name = name;
    }

    public void setNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException("Recipe.number cannot be less than 1");
        }

        this.number = number;
    }

    public void setRecipeSteps(ArrayList<Step> stepList) {
        if(stepList == null) {
            throw new IllegalArgumentException("Recipe.stepList cannot be null");
        }
        if(stepList.size() == 0) {
            throw new IllegalArgumentException("Recipe.stepList cannot be empty");
        }
        this.stepList = stepList;
    }

    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        if(ingredientList == null) {
            throw new IllegalArgumentException("Recipe.ingredientList cannot be null");
        }
        if(ingredientList.size() == 0) {
            throw new IllegalArgumentException("Recipe.ingredientList cannot be empty");
        }
    }

}
