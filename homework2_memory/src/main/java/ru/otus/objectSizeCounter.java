package ru.otus;


class objectSizeCounter {

    int size = 20_000_000;
    Class<?> tClass;
    Runtime runtime = Runtime.getRuntime();
    public objectSizeCounter(Class<?> tClass)
    {
        this.tClass = tClass;
    }
    public int countMem(){

        Object[] objects = new Object[size];
        cleanMem();
        long mem0 = getMem();
        for (int i = 0; i < size; i++) {
            try {
                objects[i] = tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Created " + size + " objects.");
        long mem1 = getMem();
        System.out.println("Counting size of the instance of the " + tClass.getName() + " Class.");
        return (int)(mem1-mem0)/size;
    }

    public static void cleanMem(){
        System.gc();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public long getMem(){
        return runtime.totalMemory() - runtime.freeMemory();
    }

}
