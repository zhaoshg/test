package com.zhaoshg.test.other;

public class SuperClass {
    private String  test = "this is SuperClass";

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public SuperClass foo(){return this;}

    public void test(){
        System.out.println(test);
        System.out.println(this.getClass().getSimpleName());
    }
}
