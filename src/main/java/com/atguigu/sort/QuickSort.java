package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = (arr[left] + arr[right])/2;
        int temp = 0;

        while (l < r) {
            while (arr[l] < pivot) {
                l ++;
            }
            while (arr[r] > pivot) {
                r --;
            }

            if(l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //避免出现左右两边的值跟pivot相等  然后出现死循环的情况
            if(arr[l] == pivot) {
                r--;
            }
            if(arr[r] == pivot) {
                l++;
            }

        }

        //如果l==r，必须l++  r--  否则栈溢出
        if(l == r) {
            l ++;
            r --;
        }

        if(left < r) {
            quickSort(arr, left, r);
        }

        if(right > l) {
            quickSort(arr, l, right);
        }
    }


}
