package com.practice.lld.factory.usingfactory;

public class EmailNotification implements Notification {

    public void send(String message, String recipient) {
        // Logic to send email
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}
