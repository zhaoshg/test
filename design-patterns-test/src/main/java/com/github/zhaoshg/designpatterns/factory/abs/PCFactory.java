package com.github.zhaoshg.designpatterns.factory.abs;


public abstract class PCFactory implements Mouse, Keyboard,Mic {

    public abstract Mouse createMouse();

    public abstract Keyboard createKeyboard();

    public abstract Mic createMic();

}
