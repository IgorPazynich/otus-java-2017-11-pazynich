package ru.otus;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<String> list = new LinkedList<>();
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
        new AddToList().start();
        new AddToList().start();
        new AddToList().start();
        new AddToList().start();
        new AddToList().start();
        new AddToList().start();

    }
}
