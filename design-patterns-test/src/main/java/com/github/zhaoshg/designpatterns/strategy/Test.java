package com.github.zhaoshg.designpatterns.strategy;

import java.util.Date;

public class Test {
    public static void main(String[] args) {

        DateContext context = new DateContext();
        context.setStrategy(new StrategyToSec());
        System.out.println(context.getRes(new Date()));


        context.setStrategy(new StrategyToDay());
        System.out.println(context.getRes(new Date()));
    }
}
