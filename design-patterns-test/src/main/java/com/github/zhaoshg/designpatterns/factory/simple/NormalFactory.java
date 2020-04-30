package com.github.zhaoshg.designpatterns.factory.simple;

public class NormalFactory {

        public MessageSender produce(String type){
            switch (type){
                case "email":
                    return new EmailSender();
                case "sms":
                    return new SMSSender();
                default:
                    return null;
            }
        }

    public static void main(String[] args) {
        NormalFactory nf = new NormalFactory();
        MessageSender messageSender = nf.produce("sms");
        messageSender.sender("");
    }
}