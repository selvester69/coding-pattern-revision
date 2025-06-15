package com.practice.lld.factory.usingfactory;

public class Client {

    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(NotificationType.EMAIL, "Hello via Email", "user@example.com");
        notificationService.sendNotification(NotificationType.SMS, "Hello via SMS", "1234567890");
        notificationService.sendNotification(NotificationType.PUSH, "Hello via Push Notification", "user123");
    }
}
