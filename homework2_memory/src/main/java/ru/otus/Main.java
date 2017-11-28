package ru.otus;

import java.lang.management.ManagementFactory;


public class Main {
    public static void main(String[] args) {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
        ObjectSizeCounter objectMemCount = new ObjectSizeCounter(new Object().getClass());
        ObjectSizeCounter stringMemCount = new ObjectSizeCounter(new String().getClass());
        ObjectSizeCounter myClassMemCount = new ObjectSizeCounter(new MyClass().getClass());
        int i = 1;
        while (true) {
            System.out.println("Stage " + i + " begin");
            System.out.println("It is " + objectMemCount.countMem() + " bytes");
            System.out.println("It is " + stringMemCount.countMem() + " bytes");
            System.out.println("It is " + myClassMemCount.countMem() + " bytes");
            System.out.println("Stage " + i + " end");
            System.out.println("*********************************************************");
            i++;
        }
    }
}
