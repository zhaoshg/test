package com.zhaoshg.test.binary;

import org.junit.Test;

/**
 * TODO Write down the function of this class
 *
 * @Description
 * @auther zhaoshg    mail:mr.zhaoshg@gmail.com
 * @create 2019-01-25 8:37
 */
public class CodeExchange {

    @Test
    public void test() {
        int i = 5;
        int j = 10;
        // -n = ~n + 1
        System.out.println(~j);
        System.out.println(i + ~j);
    }
}
