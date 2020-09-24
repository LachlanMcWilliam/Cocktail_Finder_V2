package com.cocktailFinder.api.services.threading.workers;

import com.cocktailFinder.api.models.APIModels.Cocktail;
import com.cocktailFinder.api.models.commonModels.Ingredient;
import com.cocktailFinder.api.models.jsonModels.drinks.FullDrink;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

public class RankedCocktailWorker extends AbstractCocktailWorker {
    public RankedCocktailWorker(ArrayList<Cocktail> cocktails, HashMap<String, Boolean> ingredients, int Id) {
        super(Id, cocktails, new RestTemplate(), ingredients);
    }

    @Override
    public void run() {
        FullDrink[] drinks = this.getCocktail();
        if (drinks.length > 0) {
            double hasCount = 0;
            Cocktail c = null;
            try {
                c = drinks[0].mapToCocktail();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            for (Ingredient i : c.getIngredients()) {
                if (ingredients.containsKey(i.getName().toUpperCase())) {
                    hasCount++;
                    i.setHas(true);
                }
            }
            c.setAccuracy((int) ((hasCount / c.getIngredients().size()) * 100));
            if (c.getAccuracy() > 20) {
                synchronized (this) {
                    cocktails.add(c);
                }
            }
        }
    }
}
