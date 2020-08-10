package com.zhaoshg.test;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1000.00);

        BigDecimal[] results = a.divideAndRemainder(BigDecimal.valueOf(1000.00));
        if (results[1].compareTo(BigDecimal.ZERO) != 0)  {
            System.out.println("客户经理调整金额必须为1000的整数倍");
        }else
        System.out.println("success");
    }

}
