package com.cocktailFinder.api;

import com.cocktailFinder.api.utilities.APIUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CocktailApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocktailApiApplication.class, args);
        //Run this at start-up to get the API key from the key API
        APIUtils.getAPIKey();
    }

}
