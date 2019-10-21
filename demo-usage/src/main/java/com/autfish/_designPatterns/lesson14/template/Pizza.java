package com.autfish._designPatterns.lesson14.template;

public class Pizza {
    private String crust;
    private String ingredients;
    private String sauce;

    public Pizza() {
    }

    public String toString() {
        return crust + ingredients + "披萨";
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
}
