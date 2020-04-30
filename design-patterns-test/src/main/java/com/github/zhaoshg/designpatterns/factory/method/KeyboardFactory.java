package com.github.zhaoshg.designpatterns.factory.method;

public class KeyboardFactory implements  Factory {
    @Override
    public Product manufacture() {
        System.out.println(" manufacture a Keyboard ");
        return new Keyboard();
    }
}
