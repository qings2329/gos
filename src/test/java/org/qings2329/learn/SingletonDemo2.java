package org.qings2329.learn;

public class SingletonDemo2 {

    private static final SingletonDemo2 instance = new SingletonDemo2();


    private SingletonDemo2(){
        System.out.println("生成实例");
    }

    public static SingletonDemo2 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("启动");
        SingletonDemo2.getInstance();
        System.out.println("结束");
    }

}
