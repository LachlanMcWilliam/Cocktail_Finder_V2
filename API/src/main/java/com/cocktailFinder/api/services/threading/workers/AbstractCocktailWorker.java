package com.cocktailFinder.api.services.threading.workers;

import com.cocktailFinder.api.models.APIModels.Cocktail;
import com.cocktailFinder.api.models.jsonModels.drinkLists.FullDrinkList;
import com.cocktailFinder.api.models.jsonModels.drinks.FullDrink;
import com.cocktailFinder.api.utilities.APIUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class AbstractCocktailWorker implements Runnable {
    protected final int cocktailId;
    protected final ArrayList<Cocktail> cocktails;
    protected final RestTemplate api;
    protected final HashMap<String, Boolean> ingredients;

    public AbstractCocktailWorker(int cocktailId, ArrayList<Cocktail> cocktails, RestTemplate api, HashMap<String, Boolean> ingredients) {
        this.cocktailId = cocktailId;
        this.cocktails = cocktails;
        this.api = api;
        this.ingredients = ingredients;
    }

    @Override
    public void run() {
    }

    protected FullDrink[] getCocktail() {
        FullDrink[] drinks;
        try {
            drinks = Objects.requireNonNull(api.getForObject(APIUtils.getDrinkByIdURL(this.cocktailId), FullDrinkList.class)).getDrinks();
        } catch (Exception ex) {
            System.out.println("Error getting drink: " + cocktailId);
            System.out.println(ex.fillInStackTrace());
            return null;
        }
        return drinks;
    }
}
