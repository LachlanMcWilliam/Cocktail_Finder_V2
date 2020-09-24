package com.cocktailFinder.api.models.APIModels;

import com.cocktailFinder.api.models.commonModels.Ingredient;

import java.util.ArrayList;

public class Cocktail implements Comparable<Cocktail> {
    private int id;
    private String name;
    private String instructions;
    private String thumbnail;
    private int accuracy;

    private ArrayList<Ingredient> ingredients;

    public Cocktail(int id, String name, String instructions, String thumbnail, ArrayList<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.thumbnail = thumbnail;
        this.ingredients = ingredients;
        this.accuracy = 1000;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int compareTo(Cocktail o) {
        return o.accuracy - this.accuracy;
    }
}
