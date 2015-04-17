package Comparator;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        StudentHelper a = new StudentHelper();
        Student[] array = new Student[4];
        array[0] = new Student(100,20);
        array[1] = new Student(80,19);
        array[2] = new Student(104,24);
        array[3] = new Student(140,18);
        a.buble(array);
        System.out.println();

    }
}

