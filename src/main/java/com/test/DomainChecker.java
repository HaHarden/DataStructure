package com.test;

import java.net.*;

public class DomainChecker {
    public static void main(String[] args) {
        args = new String[]{"www.baidu.com","www.taobao.com","www.123bfhsgau.com"};
        // 假设域名作为参数传入程序
        for (String arg : args) {
            check(arg);
        }
    }

    public static void check(String domain) {
        try {
            // 尝试建立TCP连接
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(domain, 80), 5000);
            socket.close();

            // 如果连接成功，则输出活跃
            System.out.println(domain + " 是活跃的");
        } catch (Exception e) {
            // 如果连接失败，则输出不活跃
            System.out.println(domain + " 是不活跃的");
        }
    }
}
