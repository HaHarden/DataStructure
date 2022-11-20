package com.leetcode.array.preSum;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 二维数组中的前置和数组
 */
public class Solution304 {
    public static void main(String[] args) {

    }

    class NumMatrix {
        //前缀和数组
        int[][] preSum;
        public NumMatrix(int[][] matrix) {
            int row = matrix.length+1;
            int col = matrix[0].length+1;
            preSum = new int[row][col];
            for(int i=1;i<row;i++) {
                for(int j=1;j<col;j++) {
                    preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
        }
    }
}
