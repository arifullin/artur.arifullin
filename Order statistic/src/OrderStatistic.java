package ru.itis.group403.arifullin.statistic;

import java.util.ArrayList;
import java.util.Collections;

public class OrderStatistic {

    public static  <T extends Comparable> T find(int number,ArrayList<T> something){
        T medianAbsolute;
        int somethingOnFive = something.size()/5;
        int magick = 5;
        if (something.size() < 50){
            Collections.sort(something);
            return something.get(number);
        }
        else {
            ArrayList<T> s1 = new ArrayList<>(somethingOnFive);
            ArrayList<T> s2 = new ArrayList<>(somethingOnFive);
            ArrayList<T> s3 = new ArrayList<>(somethingOnFive);
            ArrayList<ArrayList<T>> allOnFive = new ArrayList<>(somethingOnFive);
            for (int i = 0; i < somethingOnFive ; i++) {
                allOnFive.add(new ArrayList<T>(magick));
            }
            for (int i = 0; i < somethingOnFive; i++) {
                int count = 0;
                for (int j = 0; j < magick; j++) {
                    allOnFive.get(i).add(j, something.get(count++));
                }
                Collections.sort(allOnFive.get(i));
            }
            ArrayList<T> median = new ArrayList<>(somethingOnFive);
            for (int i = 0; i < somethingOnFive; i++) {
                median.add(allOnFive.get(i).get(2));
            }
            medianAbsolute = find(median.size()/2,median);
            for (int i = 0; i < something.size(); i++) {
                if (something.get(i).compareTo(medianAbsolute < 0)){
                	s1.add(something.get(i));
                }
                if (something.get(i).compareTo(medianAbsolute = 0)){
                	s2.add(something.get(i));
                }
                if (something.get(i).compareTo(medianAbsolute > 0)){
                	s3.add(something.get(i));
                }
            }
           
            if (s1.size() -1 >= number){
                return find(number,s1);
            }else {
                if (s1.size()+s2.size() - 1>= number){
                    return medianAbsolute;
                }else {
                    return find(number - s1.size()-s2.size(),s3);
                }
            }

        }
    }


}
