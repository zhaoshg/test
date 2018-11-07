package com.github.zhaoshg.designpatterns.factory.abs;

public abstract class BaseMic implements Mic {
    public void getMic() {
        System.out.println(this.getClass().getSimpleName());
    }
}
