package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

    }

    public static void insertSort(int[] arr) {

        for(int i=0; i<arr.length-1; i++) {
            //定义要插入的元素
            int inserVal = arr[i+1];
            //定义要插入元素的前一个元素的下标
            int insertIndex = i;

            while (insertIndex >= 0 && inserVal < arr[insertIndex]) { //若要插入的元素比前一个元素小，证明还没找到插入位置
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环，证明找到了插入位置  insertIndex+1
            arr[insertIndex+1] = inserVal;
        }



    }
}
