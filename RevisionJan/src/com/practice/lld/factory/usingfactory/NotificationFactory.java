package com.practice.lld.factory.usingfactory;

public class NotificationFactory {

    public static Notification geNotification(NotificationType type) {

        return switch (type.lable) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SMSNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknow Type");
        };
    }

}
