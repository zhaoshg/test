package com.github.zhaoshg.designpatterns.factory.abs;

public class HPFactory extends PCFactory {

    @Override
    public Mouse createMouse() {
        Mouse hpMouse = new HPMouse();
        ((HPMouse) hpMouse).getMouse();
        return hpMouse;
    }

    @Override
    public Keyboard createKeyboard() {
        Keyboard hpKeyboard = new HPKeyboard();
        ((HPKeyboard) hpKeyboard).getKeyboard();
        return hpKeyboard;
    }

    @Override
    public Mic createMic() {
        Mic mic  = new HPMic();
        ((HPMic) mic).getMic();
        return mic;
    }
}
