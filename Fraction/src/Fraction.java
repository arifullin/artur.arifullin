package ru.itis.group403.arifullin;

import java.util.AbstractCollection;

public class Fraction {
    public void reduction(int numerator,int denominator){
        if (denominator == 0){
            System.out.println("Denomitor could not be 0");
            return;
        }
        int nod = 1;
        int count = 1;
        while (count<=numerator&&count<=denominator){
            if (numerator%count==0&&denominator%count==0){
                nod = count;
            }
            count++;
        }
        numerator = numerator/nod;
        denominator = denominator/nod;
        System.out.println(numerator+" "+denominator);
    }
    public static void main(String[] args) {
        int numerator = 0;
        int denominator = 0;
        try {
            numerator = Integer.parseInt(args[0]);
            denominator = Integer.parseInt(args[1]);
            Fraction fraction = new Fraction();
            fraction.reduction(numerator,denominator);
        }catch (NumberFormatException e){
            System.out.println("Incorect input");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Incorect input");
        }
    }
}
