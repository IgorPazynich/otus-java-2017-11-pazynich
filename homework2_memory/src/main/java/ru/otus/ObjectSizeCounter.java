package ru.otus;

class ObjectSizeCounter {
    long mem0;
    int size = 20_000_000;
    Class<?> tClass;
    Runtime runtime = Runtime.getRuntime();
    public ObjectSizeCounter(Class<?> tClass) {
        this.tClass = tClass;
    }

    public int countMem(){
        System.out.println("-------------------------------");
        Object[] objects = new Object[size];
        cleanMem();
        mem0 = getMem();
        for (int i = 0; i < size; i++) {
            try {
                objects[i] = tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i == 1000) {
                printMem(i);
            }
            if (i == 10000) {
                printMem(i);
            }
            if (i == 100000) {
                printMem(i);
            }
            if (i == 1000000) {
                printMem(i);
            }
            if (i == 10000000) {
                printMem(i);
            }

        }
        System.out.println("Created " + size + " objects.");
        printMem(size);
        long mem1 = getMem();
        System.out.println("Counting size of the instance of the " + tClass.getName() + " Class.");
        cleanMem();
        return (int)(mem1-mem0)/size;
    }

    private void printMem(int size) {
        System.out.println(size + " instances of " + tClass.getName() + " in array take: " + (getMem() - mem0) + " bytes");
    }

    public static void cleanMem(){
        System.gc();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public long getMem(){
        return runtime.totalMemory() - runtime.freeMemory();
    }

}
