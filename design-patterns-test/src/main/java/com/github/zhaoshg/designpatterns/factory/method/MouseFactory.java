package com.github.zhaoshg.designpatterns.factory.method;

public class MouseFactory implements  Factory {
    @Override
    public Product manufacture() {
        System.out.println(" manufacture a Mouse ");
        return new Mouse();
    }
}
