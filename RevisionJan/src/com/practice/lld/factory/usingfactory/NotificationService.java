package com.practice.lld.factory.usingfactory;

public class NotificationService {

    public void sendNotification(NotificationType type, String message, String recipient) {
        Notification notification = NotificationFactory.geNotification(type);
        notification.send(message, recipient);
        // switch (type.toLowerCase()) {
        // case "email":
        // new EmailNotification().send(message, recipient);
        // break;
        // case "sms":
        // new SMSNotification().send(message, recipient);
        // break;
        // case "push":
        // new PushNotification().send(message, recipient);
        // break;
        // default:
        // throw new IllegalArgumentException("Unknown notification type: " + type);
        // }
    }

}
