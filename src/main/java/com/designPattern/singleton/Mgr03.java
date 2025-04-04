package com.designPattern.singleton;

/**
 * 懒汉式
 *  线程不安全
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;
    private Mgr03(){
    };

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() ->
                System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }
    }
}
