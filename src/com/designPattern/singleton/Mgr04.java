package com.designPattern.singleton;

/**
 * 懒汉式
 *  synchronized 保证线程安全
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;
    private Mgr04(){
    };

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() ->
                System.out.println(Mgr04.getInstance().hashCode())
            ).start();
        }
    }
}
