package com.zhaoshg.test.other;

public class SubC extends SuperC{

    protected String  test = "this is SubC";

    public static void main(String[] args) {
        SubC sub = new SubC();
        sub.test();
    }
}
