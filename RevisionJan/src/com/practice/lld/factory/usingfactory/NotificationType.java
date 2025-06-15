package com.practice.lld.factory.usingfactory;

public enum NotificationType {
    SMS("SMS"), PUSH("PUSH"), EMAIL("EMAIL");

    public String lable;

    private NotificationType(String label) {
        this.lable = label;
    }

}
