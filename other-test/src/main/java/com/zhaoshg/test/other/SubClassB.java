package com.zhaoshg.test.other;

import org.junit.Test;

public class SubClassB extends SuperClass {

    protected String test = "this is SubClassB";

    public SuperClass foo(){
        return this;
    }


    @Test
    public void test1() {
        SubClassB sub = new SubClassB();
        sub.test();
    }

    public static void staticmethod(){}

    public void method1(){

    }

}
