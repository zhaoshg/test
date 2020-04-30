package com.github.zhaoshg.designpatterns.strategy;

import java.util.Date;

public class DateContext {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public String getRes(Date date) {
        return strategy.formatTime(date);
    }
}
