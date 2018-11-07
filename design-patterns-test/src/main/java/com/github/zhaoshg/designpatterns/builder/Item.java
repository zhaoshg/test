package com.github.zhaoshg.designpatterns.builder;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
