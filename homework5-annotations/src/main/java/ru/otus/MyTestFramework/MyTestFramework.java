package ru.otus.MyTestFramework;


import ru.otus.MyTestFramework.annotations.After;
import ru.otus.MyTestFramework.annotations.Before;
import ru.otus.MyTestFramework.annotations.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class MyTestFramework {
    static void myClassRunner(Class<?>... types){
        for (Class<?> type : types) {
            Object object = ReflectionHelper.instantiate(type);
            Method[] methods = type.getMethods();
            ArrayList<String> tests = new ArrayList<>();
            String before = "";
            String after = "";
            for (Method method : methods) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Test){
                        tests.add(method.getName());
                    }
                    if (annotation instanceof Before){
                        before = method.getName();
                    }
                    if (annotation instanceof After){
                        after = method.getName();
                    }
                }
            }
            for (String test : tests) {
                System.out.println("Testing method " + test + "...");
                if (!before.equals("")){
                    ReflectionHelper.callMethod(object, before);
                }
                ReflectionHelper.callMethod(object, test);
                if (after=="after"){
                    ReflectionHelper.callMethod(object, after);
                }
                System.out.println();
            }
        }
    }

    static void myPackageRunner (String pkgname){
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        File directory = null;
        String fullPath;
        String relPath = pkgname.replace('.', '/');
        System.out.println("ClassDiscovery: Package: " + pkgname + " becomes Path:" + relPath);
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
        System.out.println("ClassDiscovery: Resource = " + resource);
        if (resource == null) {
            throw new RuntimeException("No resource for " + relPath);
        }
        fullPath = resource.getFile();
        System.out.println("ClassDiscovery: FullPath = " + resource);

        try {
            directory = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(pkgname + " (" + resource + ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...", e);
        } catch (IllegalArgumentException e) {
            directory = null;
        }
        System.out.println("ClassDiscovery: Directory = " + directory);
        if (directory != null && directory.exists()) {
            String[] files = directory.list();
            for (int i = 0; i < files.length; i++) {
                if (files[i].endsWith(".class")) {
                    String className = pkgname + '.' + files[i].substring(0, files[i].length() - 6);
                    System.out.println("ClassDiscovery: className = " + className);
                    try {
                        classes.add(Class.forName(className));
                    }
                    catch (ClassNotFoundException e) {
                        throw new RuntimeException("ClassNotFoundException loading " + className);
                    }
                }
            }
        }
        for (Class<?> type : classes) {
            myClassRunner(type);
        }
    }
}
