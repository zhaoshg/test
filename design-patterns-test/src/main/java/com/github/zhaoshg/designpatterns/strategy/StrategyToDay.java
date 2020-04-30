package com.github.zhaoshg.designpatterns.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

public class StrategyToDay implements Strategy {
    @Override
    public String formatTime(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
