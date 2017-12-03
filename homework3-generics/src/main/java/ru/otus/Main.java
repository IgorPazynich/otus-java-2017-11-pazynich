package ru.otus;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = new MyArrayList<>();
        Collections.addAll(list1, 4, 3, 2);
        list1.add(0, 7);
        list1.add(1);
        list1.add(1, 11);
        list1.add(3, 12);
        System.out.print("list1 after initialization is: ");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print (list1.get(i) + " ");
        }
        System.out.println();
        Collections.sort(list1, Comparator.reverseOrder());
        System.out.print("list1 after Collections.sort(list1, Comparator.reverseOrder()) is: ");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print (list1.get(i) + " ");
        }
        System.out.println();
        List<Integer> list2 = new MyArrayList<>();
        list2.add(5);
        list2.add(7);
        System.out.print("list2 after initialization is: ");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print (list2.get(i) + " ");
        }
        System.out.println();
        Collections.copy(list1, list2);
        System.out.print("list1 after Collections.copy(list1, list2) is: ");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        Collections.addAll(list2, 10, 11, 15, -7);
        System.out.print("list2 after Collections.addAll(list2, 10, 11, 15, -7) is ");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
    }
}
