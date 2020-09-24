package com.cocktailFinder.api.models.jsonModels.drinkLists;

import com.cocktailFinder.api.models.jsonModels.drinks.FullDrink;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullDrinkList {
    private FullDrink[] drinks;

    public FullDrinkList() {
    }

    public FullDrink[] getDrinks() {
        return drinks;
    }

    public void setDrinks(FullDrink[] drinks) {
        this.drinks = drinks;
    }
}
