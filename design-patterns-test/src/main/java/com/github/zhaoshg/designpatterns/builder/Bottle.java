package com.github.zhaoshg.designpatterns.builder;

public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
