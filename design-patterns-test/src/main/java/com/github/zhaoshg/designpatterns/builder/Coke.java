package com.github.zhaoshg.designpatterns.builder;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public float price() {
        return (float) 30.0;
    }
}
