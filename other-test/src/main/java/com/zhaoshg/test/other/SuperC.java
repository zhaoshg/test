package com.zhaoshg.test.other;

public class SuperC {
    private String  test = "this is SuperC";

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void test(){
        System.out.println(test);
        System.out.println(this.getClass().getSimpleName());
    }
}
