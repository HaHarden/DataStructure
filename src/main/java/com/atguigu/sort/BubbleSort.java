package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {

        //int arr[] = {1, 2, 3, 4, 5};
        //int arr[] = {3, 9, -1, 10, 20};
        //int arr[] = (3, 9, -1, 10, -2);

        //System.out.println("原数组");
        //System.out.println(Arrays.toString(arr));

        int arr[] = new int[80000];
        for(int i=0; i<80000; i++) {
            arr[i] = (int)(Math.random() * 800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println(date1Str);

        bubbleSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println(date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false; //判断一趟排序是否有过交换

        for(int i=0; i<arr.length-1; i++) {

            for(int j=0; j<arr.length-1-i; j++) {

                if(arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            //System.out.println("第" +(i+1)+ "趟排序结果为");
            //System.out.println(Arrays.toString(arr));


            if(!flag) {
                break;
            } else {
                flag = false; //为了判断下一趟排序是否有过交换
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
