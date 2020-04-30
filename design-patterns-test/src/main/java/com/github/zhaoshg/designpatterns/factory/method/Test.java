package com.github.zhaoshg.designpatterns.factory.method;

public class Test {
    public static void main(String[] args) {
        Factory mouseFactory = new MouseFactory();
        mouseFactory.manufacture().show();

        Factory keyboardFactory = new KeyboardFactory();
        keyboardFactory.manufacture().show();
    }
}