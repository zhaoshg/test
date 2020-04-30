package com.github.zhaoshg.designpatterns.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StrategyToSec implements Strategy {
    @Override
    public String formatTime(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return formatter.format(date);
    }
}
