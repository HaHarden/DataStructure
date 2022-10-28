package com.atguigu.sparseArray;

public class SparseArray {
    public static void main(String[] args) {

        //创建原二维数组 11*11，0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][5] = 1;

        //输出原数组
        System.out.println("原数组");
        for(int[] row : chessArr1) {  //重点注意：二维数组的增强for循环
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for(int i=0;i<11;i++) {
            for(int j=0;j<11;j++) {
                if(chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //第一行赋值
        int count = 0;  //重点注意！！！：用count来表示第几个不为0的数
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //其余行赋值
        for(int i=0;i<11;i++) {
            for(int j=0;j<11;j++) {
                if(chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组");
        for(int i=0;i<sum+1;i++) {
            for(int j=0;j<3;j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        //稀疏数组恢复为原二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=1; i<sum+1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("恢复的二维数组");
        for(int[] row : chessArr2) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }


}