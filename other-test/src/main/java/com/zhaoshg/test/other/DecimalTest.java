package com.zhaoshg.test.other;

import java.math.BigDecimal;

public class DecimalTest {
    public static void main(String[] args) {
        BigDecimal base = BigDecimal.valueOf(4.0100);
        String lpr = String.valueOf(base.add(BigDecimal.valueOf(90.55).divide(new BigDecimal(100),4, BigDecimal.ROUND_HALF_UP)));
        System.out.println(lpr);
    }
}
