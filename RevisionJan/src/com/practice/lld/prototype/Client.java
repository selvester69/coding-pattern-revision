package com.practice.lld.prototype;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        ReportGenerator gen = new ReportGenerator(1, "hello", "abc");
        ReportGenerator gen2 = gen.clone();
        System.out.println(gen.id == gen2.id);
    }

}
