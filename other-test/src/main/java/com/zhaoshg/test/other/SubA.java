package com.zhaoshg.test.other;

public class SubA extends SuperClass {

    @Override
    public void test() {
        super.setTest("override super's test");
        super.test();
    }

    public static void main(String[] args) {

        SubA sub = new SubA();

        sub.test();
    }
}
