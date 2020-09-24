package com.cocktailFinder.api.services;

import com.cocktailFinder.api.models.jsonModels.drinkLists.IngredientsList;
import com.cocktailFinder.api.models.jsonModels.drinkLists.BasicDrinkList;
import com.cocktailFinder.api.services.threading.CocktailThreadingService;
import com.cocktailFinder.api.utilities.APIUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class CocktailService {

    private final RestTemplate api;

    public CocktailService() {
        this.api = new RestTemplate();
    }

    public List getIngredients(){

        List<String> ingredients = api.getForObject(APIUtils.getIngredientsURL(), IngredientsList.class)
                .getIngredientsAsStringArray();
        return ingredients;
    }

    public ArrayList getCocktails(String[] ingredients, Class<?> t) {
        HashMap<Integer, String> manifest = new HashMap<>();
        for (String ingredient : ingredients) {
            try{
                manifest.putAll(Objects.requireNonNull(api.getForObject(APIUtils.getDrinksByIngredientURL(ingredient), BasicDrinkList.class)).getDrinkIds());
            }catch (Exception ex){
                System.out.println("There was a error getting ingredient: " + ingredient);
                ex.printStackTrace();
            }

        }
        CocktailThreadingService threadingService = new CocktailThreadingService(manifest, ingredients);
        return threadingService.getCocktails(t);
    }
}
