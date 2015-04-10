package ru.kpfu.itis.group403.steganography;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choice = 0;
        System.out.println("1) Encode text in image" + '\n' +
                "2) Decode image" + '\n' + "Print 1 | 2");
        try (Scanner sc = new Scanner(System.in)) {
            choice = sc.nextInt();
            while ((choice != 1) && (choice != 2)){
                System.out.println("!!!!!! 1 OR 2!!!!!!");
                choice = sc.nextInt();
            }
        }catch (InputMismatchException e){
            System.out.println("Incorrect Symbol");
        }
        switch (choice){
            case 1:
                String pp;
                String txt;
                try(Scanner sc = new Scanner(System.in)) {
                    System.out.println("Print path to image");
                    pp = sc.nextLine();
                    System.out.println("Print text, which you want hide");
                    txt = sc.nextLine();
                }
                PictureEncoder pe = new PictureEncoder(pp,txt);
                try {
                    pe.encode();
                } catch (IOException e) {
                    System.out.println(e);
                }
            case 2:
                String picp;
                try(Scanner sc = new Scanner(System.in)){
                    System.out.println("Print path to picture");
                    picp = sc.nextLine();
                }
                PictureDecoder pd = new PictureDecoder(picp);
                try {
                    System.out.println(pd.decode());
                } catch (IOException e) {
                    System.out.println(e);
                }
        }
    }
}
