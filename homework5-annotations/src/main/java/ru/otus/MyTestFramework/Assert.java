package ru.otus.MyTestFramework;

public class Assert {
    public static void  assertEquals(Object expected, Object actual){
        String answer = expected.equals(actual)?"passed":"failed";
        System.out.println("Test for equals of " + expected.toString() + " with " + actual.toString() + " is "+ answer);
    }
}

