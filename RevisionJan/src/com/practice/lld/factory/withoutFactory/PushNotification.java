package com.practice.lld.factory.withoutFactory;

public class PushNotification {
    public void send(String message, String recipient) {
        // Logic to send push notification
        System.out.println("Sending Push Notification to " + recipient + ": " + message);
    }

}
