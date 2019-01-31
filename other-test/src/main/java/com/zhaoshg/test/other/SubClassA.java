package com.zhaoshg.test.other;

import org.junit.Test;

public class SubClassA extends SuperClass {

    @Override
    public void test() {
        super.setTest("override super's test");
        super.test();
    }

    @Test
    public void test1() {

        SubClassA sub = new SubClassA();

        sub.test();
    }
}
