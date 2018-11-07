package com.github.zhaoshg.designpatterns.builder;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public float price() {
        return (float) 35.0;
    }
}
