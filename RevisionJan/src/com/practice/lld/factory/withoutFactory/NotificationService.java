package com.practice.lld.factory.withoutFactory;

public class NotificationService {

    public void sendNotification(String type, String message, String recipient) {
        switch (type.toLowerCase()) {
            case "email":
                new EmailNotification().send(message, recipient);
                break;
            case "sms":
                new SMSNotification().send(message, recipient);
                break;
            case "push":
                new PushNotification().send(message, recipient);
                break;
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }

}
