package com.practice.lld.factory.usingfactory;

public class PushNotification implements Notification {
    public void send(String message, String recipient) {
        // Logic to send push notification
        System.out.println("Sending Push Notification to " + recipient + ": " + message);
    }

}
