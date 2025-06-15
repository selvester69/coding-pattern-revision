package com.practice.lld.factory.usingfactory;

public class SMSNotification implements Notification {

    public void send(String message, String recipient) {
        // Logic to send SMS
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }

}
