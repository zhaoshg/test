package com.github.zhaoshg.designpatterns.factory.abs;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        PCFactory factory = new HPFactory();
        factory.createKeyboard();
        factory.createMic();
        factory.createMouse();
    }
}
