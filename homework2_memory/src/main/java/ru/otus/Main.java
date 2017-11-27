package ru.otus;

import java.lang.management.ManagementFactory;


public class Main {
    public static void main(String[] args) {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
        objectSizeCounter objectMemCount = new objectSizeCounter(new Object().getClass());
        objectSizeCounter stringMemCount = new objectSizeCounter(new String().getClass());
        objectSizeCounter myClassMemCount = new objectSizeCounter(new MyClass().getClass());
        int i = 1;
        while (true) {
            System.out.println("Stage " + i + " begin");
            System.out.println("It is " + objectMemCount.countMem() + " bytes");
            System.out.println("It is " + stringMemCount.countMem() + " bytes");
            System.out.println("It is " + myClassMemCount.countMem() + " bytes");
            System.out.println("Stage " + i + " end");
            i++;
        }
    }
}
