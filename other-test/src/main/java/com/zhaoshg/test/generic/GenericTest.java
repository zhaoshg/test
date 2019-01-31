package com.zhaoshg.test.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Write down the function of this class
 *
 * @Description
 * @auther zhaoshg    mail:mr.zhaoshg@gmail.com
 * @create 2019-01-24 16:57
 */
public class GenericTest {

    public static void main(String[] args) {

        List<A> lista = new ArrayList<A>();
        List<B> listb = new ArrayList<B>();
        List list = lista;
        list = listb;

        List<? extends A> lista1 = lista;
        List<D> listd = new ArrayList<D>();
        List<? extends B> listb1 = listd;
    }


}

class Car extends Vehicle {
    public static void main(String[] args) {
        new Car().run();
    }

    private final void run() {
        System.out.println("Car");
    }
}

class Vehicle {
    private final void run() {
        System.out.println("Vehicle");
    }
}
