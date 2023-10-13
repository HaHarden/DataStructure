//package com.script;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//public class GetData {
//
//    public static void main(String[] args) throws IOException {
//
//        File file = new File("D:\\");
//        File myFile = null;
//        File[] files = file.listFiles();
//        for (File file1 : files) {
//            if(file1.getName().contains("submit")) {
//                myFile = file1;
//            }
//        }
//        InputStream is = new FileInputStream(myFile);
//        HSSFWorkbook hb2 = new
////        HSSFWorkbook hb = new HSSFWorkbook(is);
////        Sheet sheet = hb.getSheetAt(0);
//
//        Iterator<Row> iterator = sheet.iterator();
//        Map<String,String> map = new HashMap<>();
//        while (iterator.hasNext()) {
//            Row row = iterator.next();
//            Cell mail = row.getCell(1);
//            Cell name = row.getCell(2);
////            map.put(name.)
//            System.out.println();
//
//        }
//
//        //4.定义一些可复用的对象
//        int rowIndex = 0; //行的索引
//        int cellIndex = 1; //单元格的索引
//        hb.close();
//
//
//    }
//}
//
