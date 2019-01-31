package com.zhaoshg.test.other;

import java.security.Security;
import java.util.List;

public class SubClassD extends SubClassB {
    public SuperClass foo(SubClassB b){
        method1();
        return b;
    }


    public void test1(){
        method1();
        staticmethod();
    }

    public static void main(String[] args) {

        System.out.println(finallytest());
        System.out.println(finallytest2());
    }


    public static int finallytest(){
        try{
            return 0;
        }finally {
            return 1;
        }
    }
    public static int finallytest2(){
        int i = 0;
        try{
            return i;
        }finally {
            i++;
        }
    }

    static final int i = 234;
    final float iff = 3.14f;

    public void test123(){

        A a = new A();
        A b = new B();
        A c = new C();
    }

    class A {

    }
    class B extends A{

    }
    class C extends B{

    }

}
