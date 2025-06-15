package com.practice.lld.prototype;

public class ReportGenerator implements Cloneable {
    int id;
    String name;
    String type;

    public ReportGenerator(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;

    }

    @Override
    public ReportGenerator clone() throws CloneNotSupportedException {

        return (ReportGenerator) super.clone();
    }
}
