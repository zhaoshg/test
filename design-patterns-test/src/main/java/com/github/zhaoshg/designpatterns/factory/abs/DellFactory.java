package com.github.zhaoshg.designpatterns.factory.abs;

public class DellFactory extends PCFactory {

    @Override
    public Mouse createMouse() {
        Mouse mouse = new DellMouse();
        ((DellMouse) mouse).getMouse();
        return mouse;
    }

    @Override
    public Keyboard createKeyboard() {
        Keyboard keyboard = new DellKeyboard();
        ((DellKeyboard) keyboard).getKeyboard();
        return keyboard;
    }

    @Override
    public Mic createMic() {
        Mic mic = new DellMic();
        ((DellMic) mic).getMic();
        return mic;
    }


}
