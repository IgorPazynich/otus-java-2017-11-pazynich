package ru.otus;

import java.util.LinkedList;
import java.util.List;

public class AddToList extends Thread {
    @Override
    public void run() {
        Integer i = 0;
        while (true) {
                for (int j = 0; j < 5; j++) {
                    Main.list.add(new String(i.toString()));
                    i++;
                    System.out.println(i);
                }
                Main.list.remove(2);
        }
    }

}