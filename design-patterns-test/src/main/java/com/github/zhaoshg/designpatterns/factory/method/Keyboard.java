package com.github.zhaoshg.designpatterns.factory.method;

public class Keyboard implements Product {

    @Override
    public void show() {
        System.out.println("this is a " + this.getClass().getSimpleName());
    }
}
