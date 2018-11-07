package com.github.zhaoshg.designpatterns.builder;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public float price() {
        return (float) 50.5;
    }
}
