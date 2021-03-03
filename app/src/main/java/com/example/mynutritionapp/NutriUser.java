package com.example.mynutritionapp;

public class NutriUser {
    private String food, fruit, time;

    public NutriUser(String food, String fruit, String time) {
        this.food = food;
        this.fruit = fruit;
        this.time = time;
    }

    public NutriUser(String food, String fruit) {
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
