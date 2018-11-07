package com.github.zhaoshg.designpatterns.factory;

public class SMSSender implements MessageSender{
    @Override
    public void sender(String message) {
        System.out.println("this is a SMS Sender~");
    }
}
