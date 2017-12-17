package ru.otus.MyTestFramework;

public class TestRunner {
    public static void main (String[] args) {
        MyTestFramework.myClassRunner(ReflectionHelperTest.class);
        MyTestFramework.myPackageRunner("ru.otus.MyTestFramework");
    }
}
