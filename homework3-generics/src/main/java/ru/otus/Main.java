package ru.otus;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new MyArrayList<>();
        Collections.addAll(list1, 4, 3, 2);
        list1.add(0, 7);
        list1.add(1);
        list1.add(1, 11);
        list1.add(3, 12);
        System.out.println("list1 after initialization is: " + list1);
        Collections.sort(list1, Comparator.reverseOrder());
        System.out.println("list1 after Collections.sort(list1, Comparator.reverseOrder()) is: " + list1);
        List<Integer> list2 = new MyArrayList<>();
        list2.add(5);
        list2.add(7);
        System.out.println("list2 after initialization is: " + list2);
        Collections.copy(list1, list2);
        System.out.println("list1 after Collections.copy(list1, list2) is: " + list1);
        Collections.addAll(list2, 10, 11, 15, -7);
        System.out.println("list2 after Collections.addAll(list2, 10, 11, 15, -7) is " + list2);

        List<Integer> list3 = new MyArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        List<Integer> list4 = new MyArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        System.out.println("list3 after initialization is: " + list3);
        System.out.println("list4 after initialization is: " + list4);
        Collections.copy(list3, list4);
        System.out.println("list3 after Collections.copy(list3, list4) is: " + list3);
    }
}
