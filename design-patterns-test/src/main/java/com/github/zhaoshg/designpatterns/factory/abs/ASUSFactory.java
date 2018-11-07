package com.github.zhaoshg.designpatterns.factory.abs;

public class ASUSFactory extends PCFactory {

    @Override
    public Mouse createMouse() {
        Mouse mouse = new ASUSMouse();
        ((ASUSMouse) mouse).getMouse();
        return mouse;
    }

    @Override
    public Keyboard createKeyboard() {
        Keyboard keyboard = new ASUSKeyboard();
        ((ASUSKeyboard) keyboard).getKeyboard();
        return keyboard;
    }

    @Override
    public Mic createMic() {
        Mic mic = new ASUSMic();
        ((ASUSMic) mic).getMic();
        return mic;
    }


}
