package com.zhaoshg.test.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * TODO Write down the function of this class
 *ß
 * @Description
 * @auther zhaoshg    mail:mr.zhaoshg@gmail.com
 * @create 2019-01-11 17:04
 */
public class PredicateTest {

    @Test
    public void test1() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));
        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));
        System.out.println("Print all languages :");
        filter(languages, (str) -> true);
        System.out.println("Print no language : ");
        filter(languages, (str) -> false);
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
}
