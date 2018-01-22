package ru.otus.MyTestFramework;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
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
        List<URL> paths = new ArrayList<>();
        for (Class<?> aClass : allClasses) {
            if (!paths.contains(aClass.getResource(""))) paths.add(aClass.getResource(""));
        }
        paths.forEach((p)-> System.out.println(p));
        String tempPath = paths.get(0).toString().replace("classes","test-classes").replace("file:/","");
        File file0 = new File(tempPath);
        for (String s : file0.list()) {
            System.out.println(s);
        }
        URLClassLoader classLoader = null;
        try {
            classLoader = URLClassLoader.newInstance(new URL[] { file0.toURI().toURL() });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("Here " + classLoader.getResource(tempPath));
        try {
            Class<?> cls = Class.forName("ReflectionHelperTest", true, classLoader);
            System.out.println(cls.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //MyTestFramework.myPackageRunner("ru.otus.MyTestFramework");

    }
}
