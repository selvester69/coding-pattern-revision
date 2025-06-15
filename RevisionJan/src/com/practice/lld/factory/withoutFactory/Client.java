package com.practice.lld.factory.withoutFactory;

public class Client {

    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("email", "Hello via Email", "user@example.com");
        notificationService.sendNotification("sms", "Hello via SMS", "1234567890");
        notificationService.sendNotification("push", "Hello via Push Notification", "user123");
    }

}
