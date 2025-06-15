package com.practice.lld.factory.withoutFactory;

public class EmailNotification {

    public void send(String message, String recipient) {
        // Logic to send email
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}
