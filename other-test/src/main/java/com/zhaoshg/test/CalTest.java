package com.zhaoshg.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class CalTest {

    public static void main(String[] args) {
        decimalTest();

    }

    private static void decimalTest(){
        BigDecimal a=BigDecimal.valueOf(0);
        BigDecimal b =  BigDecimal.valueOf(0E-8);
        System.out.println(a.floatValue()==b.floatValue());
    }

    private static void calTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 30);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 45);
        calendar.set(Calendar.SECOND, 0);

        ConcurrentHashMap map = new ConcurrentHashMap();


        calendar.add(Calendar.MONTH, 3);
        Date expireTime = calendar.getTime();
        System.out.println(expireTime);
    }
}
