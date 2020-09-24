package com.cocktailFinder.api.models.jsonModels.drinkLists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "drinks"
})
public class IngredientsList {

    @JsonProperty("drinks")
    private List<ApiIngredient> drinks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("drinks")
    public List<ApiIngredient> getDrinks() {
        return drinks;
    }

    public List<String> getIngredientsAsStringArray() {
        return drinks.stream().map(x -> x.getStrIngredient1()).collect(Collectors.toList());
    }

    @JsonProperty("drinks")
    public void setDrinks(List<ApiIngredient> drinks) {
        this.drinks = drinks;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "drinks=" + drinks.toString() +
                '}';
    }

    class ApiIngredient {

        @JsonProperty("strIngredient1")
        private String strIngredient1;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("strIngredient1")
        public String getStrIngredient1() {
            return strIngredient1;
        }

        @JsonProperty("strIngredient1")
        public void setStrIngredient1(String strIngredient1) {
            this.strIngredient1 = strIngredient1;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public String toString() {
            return "ApiIngredient{" +
                    "strIngredient1='" + strIngredient1 + '\'' +
                    '}';
        }
    }
}