package com.github.zhaoshg.designpatterns.factory.abs;

public abstract class BaseMouse implements Mouse {
    public void getMouse() {
        System.out.println(this.getClass().getSimpleName());
    }
}
