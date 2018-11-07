package com.github.zhaoshg.designpatterns.factory.abs;

public abstract class BaseKeyboard implements Keyboard {
    public void getKeyboard() {
        System.out.println(this.getClass().getSimpleName());
    }
}
