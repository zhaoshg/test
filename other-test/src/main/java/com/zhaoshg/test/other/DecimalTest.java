package com.zhaoshg.test.other;

import java.math.BigDecimal;

public class DecimalTest {
    public static void main(String[] args) {
        BigDecimal base = BigDecimal.valueOf(4.0100);
        String lpr = String.valueOf(base.add(BigDecimal.valueOf(90.55).divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP)));
        System.out.println(lpr);
        BigDecimal a = BigDecimal.valueOf(100);
        BigDecimal b = BigDecimal.valueOf(50);
        a.add(b);
        System.out.println(a);
        a = a.add(b);
        System.out.println(a);
    }
}
