package com.github.zhaoshg.designpatterns.factory;

public class MultiFactory {

    public MessageSender produceEmail(){
        return new EmailSender();
    }

    public static MessageSender produceSMS(){
        return new SMSSender();
    }

    public static void main(String[] args) {
        MultiFactory mf = new MultiFactory();
        MessageSender messageSender = mf.produceEmail();
        messageSender.sender("");
        messageSender = MultiFactory.produceSMS();
        messageSender.sender("");
    }
}