package ru.itis.group403.arifullin;

public class MatrixMultiThread extends Thread {
    private int[][] matrix;
    private int[][] matrix2;
    private int st;
    private int end;
    private int[][] fin;
    public MatrixMultiThread(int[][] x,int[][] x2,int st,int end,int[][] fin){
        this.matrix = x;
        this.matrix2 = x2;
        this.st = st;
        this.end = end;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = st; i < end; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    fin[i][j] += matrix[i][k]*matrix2[k][j];
                }
            }
        }
    }
}
