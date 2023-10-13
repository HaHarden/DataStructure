package com.atguigu.sort;

//import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int arr[] = {101, 34, 119, -1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

        //selectSort1(arr);

    }

    public static void selectSort(int[] arr) {
        //进行n-1趟排序
        for(int i=0; i<arr.length-1; i++) {
            //假设当前数为最小数
            int minIndex = i;
            int min = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }

                //交换
                if(minIndex != i) {
                    arr[minIndex] = arr[i];
                    arr[i] = min;
                }


            }

        }
    }

    public static void selectSort1(int[] arr) {

        int min = arr[0];
        int minIndex = 0;

        //第一趟排序
        for(int j=1;j<arr.length;j++) {
            if(min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        arr[minIndex] = arr[0];
        arr[0] = min;

        System.out.println("第1趟排序");
        System.out.println(Arrays.toString(arr));

        //第二趟排序
        for(int j=1 + 1;j<arr.length;j++) {
            if(min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        arr[minIndex] = arr[1];
        arr[1] = min;

        System.out.println("第2趟排序");
        System.out.println(Arrays.toString(arr));


    }



}
