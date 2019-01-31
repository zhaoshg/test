package com.zhaoshg.test.event;

public class SkillListener implements EventListener {
    @Override
    public void handleEvent(Event event) {
        System.out.println(event.getUserName() + "升级了，学会剑神新技能");
    }
}