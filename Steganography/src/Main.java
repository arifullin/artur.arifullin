package ru.kpfu.itis.group403.steganography;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        PicrureEncoder x = new PicrureEncoder("C:/Users/хэтфилд/Desktop/lol.bmp","y");
//        try {
//            x.encode();
//        } catch (IOException e) {
//            System.out.println(e);
//        }
        PictureDecoder x = new PictureDecoder("C:/Users/хэтфилд/Desktop/lol.bmp");
        try {
            System.out.println(x.decode());
        } catch (IOException e) {
            System.out.println(e);
        }

           File temp = new File("C:/Users/хэтфилд/Desktop/lol.bmp");
//        try {
//            BufferedImage x = ImageIO.read(temp);
//            for (int i = 0; i < x.getWidth(); i++) {
//                for (int j = 0; j < x.getHeight(); j++) {
//                    x.setRGB(i, j, 0b0);
//                }
//            }
//            ImageIO.write(x, "bmp", temp);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            BufferedImage g = ImageIO.read(temp);
//            for (int i = 0; i < 700; i++) {
//                System.out.println(g.getRGB(i,0));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            BufferedImage g = ImageIO.read(temp);
//            g.setRGB(0,0,0b000000000000000000000000);
//            g.setRGB(0,1,0b00000000_00000001_00000001);
//            g.setRGB(0,2,0b00000010_00000001_00000000);
//            ImageIO.write(g,"bmp",temp);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       System.out.println((char) 89);
    }
}
