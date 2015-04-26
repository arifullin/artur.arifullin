package ru.itis.group403.arifullin.statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Random rd = new Random();
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < 10000000 ; i++) {
            x.add(i,rd.nextInt(20000000));
        }
        x.trimToSize();
        long time = System.currentTimeMillis();
        System.out.println(OrderStatistic.find(5000000, x));
        time = System.currentTimeMillis() - time;
        System.out.println(time+" My sort");
        time = System.currentTimeMillis();

        Collections.sort(x);
        System.out.println(x.get(359699));
        time = System.currentTimeMillis() - time;
        System.out.println(time+" Collection.sort");
    }
}