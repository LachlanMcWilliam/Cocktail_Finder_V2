package com.cocktailFinder.api.services.threading;

import com.cocktailFinder.api.models.APIModels.Cocktail;
import com.cocktailFinder.api.services.threading.workers.CheckedCocktailWorker;
import com.cocktailFinder.api.services.threading.workers.RankedCocktailWorker;

import java.util.ArrayList;
import java.util.HashMap;

public class CocktailThreadingService {
    private final HashMap<Integer, String> manifest;
    private final HashMap<String, Boolean> ingredients;

    public CocktailThreadingService(HashMap<Integer, String> manifest, String[] ingredients) {
        this.manifest = manifest;
        this.ingredients = mapStringArrToMap(ingredients);
    }

    private HashMap<String, Boolean> mapStringArrToMap(String[] ingredients) {
        HashMap<String, Boolean> ingredientMap = new HashMap<>();
        for (String i : ingredients) {
            ingredientMap.put(i.toUpperCase(), true);
        }
        return ingredientMap;
    }

    public ArrayList<Cocktail> getCocktails(Class<?> t) {
        ArrayList<Integer> cocktailIds = new ArrayList<>(manifest.keySet());
        ArrayList<Cocktail> cocktails = new ArrayList<>();
        if (t == CheckedCocktailWorker.class) {
            cocktailIds.parallelStream().forEach(id -> new CheckedCocktailWorker(cocktails, ingredients, id).run());
        } else if (t == RankedCocktailWorker.class) {
            cocktailIds.parallelStream().forEach(id -> new RankedCocktailWorker(cocktails, ingredients, id).run());
        } else {
            System.out.println("An invalid type has been passed to the threading service");
        }
        return cocktails;
    }
}
