package org.qings2329.learn;

public class DoubleCheckSingleton {

    static {
       System.out.println("load class");
    }

    private DoubleCheckSingleton() {
    }

    private static volatile DoubleCheckSingleton instance;

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }


}
