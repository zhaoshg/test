package com.zhaoshg.test.loganalyes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: RegularTest
 *
 * @description:
 *
 * @author zhaoshuguang
 *
 * @Date 2019-07-01
 */
public class RegularTest {

    private static String timeRegex = "cost:\\[([0-9]*)\\]";//匹配大括号
    private static String threadIdRegex = " \\[([0-9]*)-boss\\]\\[";//匹配小括号

    public static void main(String[] args) {
        String logStr = "20190619 07:31:12 306 [201906190731121531829092-boss][INFO]-thread end --> cost:[153]";
        Pattern compile = Pattern.compile(timeRegex);
        Matcher matcher = compile.matcher(logStr);
        while (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
        }


        Pattern comp = Pattern.compile(threadIdRegex);
        Matcher mat = comp.matcher(logStr);
        while (mat.find()) {
            String group = mat.group(1);
            System.out.println(group);
        }
    }
}
