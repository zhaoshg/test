package com.zhaoshg.test.other;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberTest {


    public static void main(String[] args) {
//        Integer level = null;
//        assert level != null;
//        boolean res = (level) == 2;

//        Integer status = 4;
//        String s = String.valueOf(status).substring(1,2);
//        System.out.println(s);


        BigDecimal sysIrFloatUp = BigDecimal.valueOf(-50.55000000);// 群体基点调整数上限

        System.out.println("群体基点调整数上限配置为：" + sysIrFloatUp);
        double apprFloatIr = -50.55;

        System.out.println( BigDecimal.valueOf(apprFloatIr));
        System.out.println( BigDecimal.valueOf(apprFloatIr).compareTo(sysIrFloatUp));
    }

}
