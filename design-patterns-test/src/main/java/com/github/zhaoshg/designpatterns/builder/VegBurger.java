package com.github.zhaoshg.designpatterns.builder;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public float price() {
        return (float) 25.0;
    }
}
