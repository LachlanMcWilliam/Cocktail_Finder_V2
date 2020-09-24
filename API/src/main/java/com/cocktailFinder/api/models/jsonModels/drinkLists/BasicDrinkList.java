package com.cocktailFinder.api.models.jsonModels.drinkLists;

import com.cocktailFinder.api.models.jsonModels.drinks.BasicDrink;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicDrinkList {

    private BasicDrink[] drinks;

    public BasicDrinkList() {
    }

    public BasicDrink[] getDrinks() {
        return drinks;
    }

    public void setDrinks(BasicDrink[] drinks) {
        this.drinks = drinks;
    }

    public HashMap<Integer, String> getDrinkIds() {
        HashMap<Integer, String> cocktails = new HashMap<>();
        for (BasicDrink drink : drinks) {
            cocktails.put(drink.getIdAsInt(), drink.getStrDrink());
        }
        return cocktails;
    }
}
