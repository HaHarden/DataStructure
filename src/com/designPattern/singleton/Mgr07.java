package com.designPattern.singleton;

/**
 * 静态内部类的方式
 * JVM保证单例
 * Mgr07被加载的时候，其内部的静态内部类Mgr07Holder是不会被初始化的，当调用getInstance的时候才会初始化
 * 加载外部类时不回加载内部类，这样可以实现懒加载
 */
public class Mgr07 {
    private Mgr07(){
    };

    public static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() ->
                System.out.println(Mgr07.getInstance().hashCode())
            ).start();
        }
    }
}
