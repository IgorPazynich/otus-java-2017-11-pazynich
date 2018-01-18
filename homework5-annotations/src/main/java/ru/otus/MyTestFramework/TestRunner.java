package ru.otus.MyTestFramework;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;

public class TestRunner {
    public static void main (String[] args) {
        //MyTestFramework.myClassRunner(ReflectionHelperTest.class);
        String packageName = "ru.otus.MyTestFramework";
        Reflections reflections = new Reflections(
                packageName, new SubTypesScanner(false)
        );

        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(
                Object.class
        );
        allClasses.forEach((cl->System.out.println(cl)));
        MyTestFramework.myPackageRunner("ru.otus.MyTestFramework");

    }
}
