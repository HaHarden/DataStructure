package com.test;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExcelDomainChecker {
    public static void main(String[] args) {
        // 假设Excel文件名作为参数传入程序
        if (args.length != 3) {
            System.out.println("传参错误，必须传三个参数，第一个参数是excel路径，第二个参数是端口列表(以英文逗号间隔-只有一个端口除外),第三个参数是服务器响应时间");
            System.exit(0);
        }
        String excelFile = args[0];
//        String excelFile = "D:/域名.xlsx";
        String ports = args[1];
        List<String> portList = convert(ports);
//        String ports = "80,443";
        if (!excelFile.endsWith(".xls") && !excelFile.endsWith(".xlsx")) {
            System.out.println(excelFile + " 文件格式错误，请输入Excel文件(xlsx或xls格式)");
            System.exit(0);
        }
        File file2 = new File(excelFile);
        if (!file2.exists()) {
            System.out.println(excelFile + " 文件不存在！");
            System.exit(0);
        }
        try {
            // 读取Excel文件
            FileInputStream file = new FileInputStream(excelFile);
            Workbook workbook = new XSSFWorkbook(file);

            // 遍历每个sheet
            for (Sheet sheet : IteratorUtils.toList(workbook.sheetIterator())) {
                System.out.println("Sheet: " + sheet.getSheetName());

                // 遍历每一行
                for (Row row : IteratorUtils.toList(sheet.rowIterator())) {
                    // 读取域名所在的单元格，假设是第一列
                    Cell cell = row.getCell(0);

                    // 判断单元格是否为空
                    if (cell != null) {
                        String domain = cell.getStringCellValue().trim();
                        if (!isValid(domain) && !isValidIP(domain)) {
                            System.out.println(domain + " 格式错误");
                            continue;
                        }

                        // 尝试建立TCP连接
                        for (String port : portList) {
                            try {
                                Socket socket = new Socket();
                                socket.connect(new InetSocketAddress(domain, Integer.parseInt(port)), Integer.parseInt(args[2]));
                                socket.close();
                                // 如果连接成功，则输出活跃
                                System.out.println(domain + " 的端口 " + port + " 是活跃的");
                            } catch (Exception e) {
                                // 如果连接失败，则输出不活跃
                                System.out.println(domain + " 的端口 " + port + " 是不活跃的");
                            }
                        }
                    }
                }
            }

            // 关闭文件
            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> convert(String ports) {
        List<String> portList = new ArrayList<>();
        String[] split = ports.split(",");
        for (String s : split) {
            portList.add(s);
        }
        return portList;
    }

    public static boolean isValid(String domainName) {
        if (domainName == null || domainName.isEmpty()) {
            return false;
        }
        String domainNameRegex = "^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(domainNameRegex);
        return pattern.matcher(domainName).matches();
    }

    public static String regex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public static boolean isValidIP(String ip) {
        return ip.matches(regex);
    }
}
