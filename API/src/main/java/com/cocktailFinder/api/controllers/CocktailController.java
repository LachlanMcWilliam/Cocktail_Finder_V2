package com.cocktailFinder.api.controllers;

import com.cocktailFinder.api.models.APIModels.Cocktail;
import com.cocktailFinder.api.models.jsonModels.clientHandling.PostData;
import com.cocktailFinder.api.services.CocktailService;
import com.cocktailFinder.api.services.threading.workers.CheckedCocktailWorker;
import com.cocktailFinder.api.services.threading.workers.RankedCocktailWorker;
import com.cocktailFinder.api.utilities.APIUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CocktailController {

    final CocktailService service = new CocktailService();

    @CrossOrigin
    @GetMapping("/getIngredients")
    public List getIngredients(){
        return service.getIngredients();
    }

    @CrossOrigin
    @PostMapping("/getCheckedCocktails")
    public ArrayList getCheckedCocktails(@RequestBody PostData data) {
        return service.getCocktails(data.getIngredients(), CheckedCocktailWorker.class);
    }

    @CrossOrigin
    @PostMapping("/getRankedCocktails")
    public List<Cocktail> getRankedCocktail(@RequestBody PostData data) {
        ArrayList<Cocktail> cocktails = service.getCocktails(data.getIngredients(), RankedCocktailWorker.class);
        Collections.sort(cocktails);
        return cocktails;
    }

}
