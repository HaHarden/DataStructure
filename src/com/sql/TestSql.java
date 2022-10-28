package com.sql;

import java.sql.*;

public class TestSql {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://127.0.0.1:3306/mei1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
        String user="root";
        String password="123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from b");
        String count = "";
        while (resultSet.next()) {
            count = resultSet.getString("count(*)");
            System.out.println("行数：" + count);
        }
        int count2 = Integer.parseInt(count);
        String data1 = "";
        String data1up = "";
        String data1down = "";
        for (int i = 1; i < count2+1; i++) {
            ResultSet rs1 = statement.executeQuery("select 测试" + i +" from b");
            while (rs1.next()) {
                data1 = rs1.getString("测试" + i);
            }
            ResultSet rs1up = statement.executeQuery("select 测试" + i +"上限 from b");
            while (rs1up.next()) {
                data1up = rs1up.getString("测试" + i + "上限");
            }
            ResultSet rs1down = statement.executeQuery("select 测试" + i +"下限 from b");
            while (rs1down.next()) {
                data1down = rs1down.getString("测试" + i + "下限");
            }
            System.out.println("第" + i + "组数据：");
            System.out.println("测试" + i + "：" + data1);
            System.out.println("测试" + i + "上限：" + data1up);
            System.out.println("测试" + i + "下限：" + data1down);
            System.out.println("====================");
        }



    }
}
