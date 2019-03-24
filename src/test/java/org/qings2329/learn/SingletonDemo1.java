package org.qings2329.learn;

public class SingletonDemo1 {


    private static class SingletonClassInstance {
        private static final SingletonDemo1 instance = new SingletonDemo1();
    }

    private SingletonDemo1(){
        System.out.println("生成实例");
    }

    public static SingletonDemo1 getInstance(){
        return SingletonClassInstance.instance;
    }


    public static void main(String[] args) {
        System.out.println("启动");
        SingletonDemo1.getInstance();
        System.out.println("结束");
    }

}
