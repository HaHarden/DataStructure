package com.designPattern.singleton;

/**
 * 懒汉式
 *  试图通过缩小synchronized作用域来提高效率 但是保证不了线程安全
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;
    private Mgr05(){
    };

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() ->
                System.out.println(Mgr05.getInstance().hashCode())
            ).start();
        }
    }
}
