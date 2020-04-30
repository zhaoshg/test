package com.github.zhaoshg.designpatterns.factory.simple;

public class EmailSender implements MessageSender {
    @Override
    public void sender(String message) {
        System.out.println("this is a Email Sender ~");
    }
}
