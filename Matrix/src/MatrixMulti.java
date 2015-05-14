package ru.itis.group403.arifullin;

import java.util.Random;

public class MatrixMulti {
    public static int[][] MatrixMultiply(int[][] x1,int[][] x2,int thread){
        if (x1.length!=x2.length){
            return null;
        }
        if (thread>x1.length){
            thread = x1.length;
        }
        int[][] result = new int[x1.length][x1.length];
        int forThread = x1.length/thread;
        Thread[] threads = new MatrixMultiThread[thread];
        int st = 0;
        int end = forThread;
        if (x1.length%thread==0){
            for (int i = 0; i < thread; i++) {
                threads[i] = new MatrixMultiThread(x1,x2,st,end,result);
                st+=forThread;
                end+=forThread;
                threads[i].start();
            }
        }
        if (x1.length%thread!=0){
            for (int i = 0; i < thread; i++) {
                threads[i] = new MatrixMultiThread(x1,x2,st,end,result);
                st+=forThread;
                end+=forThread;
                threads[i].start();
            }
            new MatrixMultiThread(x1,x2,end,result.length-1,result).start();
        }
        for (Thread x:threads){
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1000;
        long time;
        int [][] matrix = new int[n][n];
        int [][] matrix2 = new int[n][n];
        int [][] result = new int[n][n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rd.nextInt()+1;
                matrix2[i][j] = rd.nextInt()+1;
            }
        }
        time = System.currentTimeMillis();
        result = MatrixMultiply(matrix,matrix2,10);
        time = System.currentTimeMillis() - time;
        System.out.println(time);
//        for (int[] x: result){
//            for (int a: x){
//                System.out.print(a+" ");
//            }
//            System.out.println();
//        }
    }
}
