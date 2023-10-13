package com.designPattern.singleton;

/**
 * 枚举单例
 * 不仅可以解决线程同步， 还可以防止反序列化（枚举类没有构造方法，java语言的规定）
 */
public enum Mgr08 {

    INSTANCE;

    public void m() {
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(() ->
                System.out.println(Mgr08.INSTANCE.hashCode())
            ).start();
        }
    }
}
