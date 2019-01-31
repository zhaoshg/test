package com.zhaoshg.test.event;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        CommonEventDispatcher dispatcher = CommonEventDispatcher.INSTANCE;
        EventListener listener1 = new AttrChangeListener();
        EventListener listener2 = new SkillListener();

        Event levelUpEvent = new LevelUpEvent("李逍遥", EventType.LEVEL_UP);
        dispatcher.registerEvent(EventType.LEVEL_UP, listener1);
        dispatcher.registerEvent(EventType.LEVEL_UP, listener2);

        dispatcher.fireEvent(levelUpEvent);
        ((Test)null).test();
    }


    private static void test(){
        System.out.println("yyyyy");
    }


    float func0(){
        byte i = 1;
        return i;
    }

    float func1(){
        int i = 1;
        return i;
    }
    float func2(){
        short i = 2;
        return i;
    }
    float func3(){
        long i = 2;
        return i;
    }
//    float func4(){
//        double i = 2;
//        return i;
//    }




}