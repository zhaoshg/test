package com.zhaoshg.test.event;

public class AttrChangeListener implements EventListener {
    @Override
    public void handleEvent(Event event) {
        System.out.println(event.getUserName() + "升级了，攻击力，防御力都将大幅提升");
    }
}
