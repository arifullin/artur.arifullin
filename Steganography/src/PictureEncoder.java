package ru.kpfu.itis.group403.steganography;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureEncoder {
    private String picturePath;
    private String toEncode;

    public PictureEncoder(String pp,String te) {
        picturePath = pp;
        toEncode = te;
    }

    private void checkImgTxt() throws IOException {
        File file = new File(picturePath);
        BufferedImage img;
        try {
            img = ImageIO.read(file);
            if (img.getHeight()*img.getWidth()*6/16<toEncode.length()){
                System.out.println("Картика слишком маленькая,часть информации будет потерена");
            }
        } catch (IOException e) {
            throw new IOException("readImageError");
        }
    }
    private  void fastReverse(byte[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            byte t = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = t;
        }
    }

    private byte[] charToBitArray(char x){
        byte[] mas = new byte[16];
        for (int i = 0; i < 16; i++) {
            mas[i] = (byte) (x&1);
            x/=0b10;
        }
        fastReverse(mas);
        return mas;
    }

    public void encode() throws IOException {
        checkImgTxt();
        int charCount = 0;
        int rgbValue = 0;
        byte bitOfChar = 0;
        byte[] masBitChar = charToBitArray(toEncode.charAt(charCount));
        File fileOfPicture = new File(picturePath);
        BufferedImage img = ImageIO.read(fileOfPicture);
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {

                rgbValue = img.getRGB(i,j);
                rgbValue = rgbValue & 0b111111001111110011111100;
                if(charCount<toEncode.length()){
                    int temp = 0;
                    for (int k = 0; k < 3; k++) {
                        if (bitOfChar > 14){
                            bitOfChar = 0;
                            charCount++;
                            if (charCount<toEncode.length()){
                                masBitChar = charToBitArray(toEncode.charAt(charCount));
                            }
                        }
                        if (charCount!=toEncode.length()){
                            temp = (temp << 7) | masBitChar[bitOfChar++];
                            temp = (temp << 1) | masBitChar[bitOfChar++];
                        }else {
                            temp <<= 8;
                        }
                    }
                    rgbValue = rgbValue | temp;
                }
                img.setRGB(i,j,rgbValue);
            }
        }
        ImageIO.write(img,"bmp", fileOfPicture);
    }

}
