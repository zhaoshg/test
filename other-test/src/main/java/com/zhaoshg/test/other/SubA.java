package com.zhaoshg.test.other;

public class SubA extends SuperC {

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
