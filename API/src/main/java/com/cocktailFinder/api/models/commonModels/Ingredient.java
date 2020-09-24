package com.cocktailFinder.api.models.commonModels;

import java.util.Objects;

public class Ingredient {
    private String name;
    private String measure;
    private boolean has;

    public Ingredient(String name, String measure) {
        this.name = name;
        this.measure = Objects.requireNonNullElse(measure, "To taste");

    }

    public boolean isHas() {
        return has;
    }

    public void setHas(boolean has) {
        this.has = has;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}