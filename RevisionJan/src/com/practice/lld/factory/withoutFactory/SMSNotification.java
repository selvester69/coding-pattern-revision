package com.practice.lld.factory.withoutFactory;

public class SMSNotification {

    public void send(String message, String recipient) {
        // Logic to send SMS
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }

}
