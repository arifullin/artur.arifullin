package ru.kpfu.itis.group403.steganography;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureDecoder {
    private String picturePath;
    public PictureDecoder(String pp){
        picturePath = pp;
    }
    private void cut(StringBuffer x){
        int begindOfEnd = 0;
        for (int i = 0; i < x.length(); i++) {
            if ((int)(x.charAt(i)) != 0){
                begindOfEnd = i;
            }
        }
        x.delete(begindOfEnd+1,x.length()-1);
    }
    private char bitArrayToChar(byte[] x){
        int temp = 0;
        for (int i = 0; i < 16; i++) {
            temp = temp*0b10 + x[i];
        }
        return (char)temp;
    }
    public String decode() throws IOException {
        File pictureFile = new File(picturePath);
        BufferedImage img = null;
        try {
            img = ImageIO.read(pictureFile);
        } catch (IOException e) {
            throw new IOException("read Image Error");
        }
        StringBuffer outDecoder = new StringBuffer();
        byte[] bitOfChar = new byte[16];
        byte bitCharCount = 0;
        int charCounter = 0;
        int rgbValue = 0;

        if (img != null){
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    rgbValue = img.getRGB(i,j);
                    for (int k = 17; k >= 1; k-=8) {
                        if (bitCharCount>14){
                            bitCharCount = 0;
                            outDecoder.append(bitArrayToChar(bitOfChar));
                        }
                        bitOfChar[bitCharCount++] = (byte)((rgbValue >> k) & 1);
                        bitOfChar[bitCharCount++] = (byte) ((rgbValue >> k-1) & 1);
                    }

                }
            }
        }
        cut(outDecoder);
        return outDecoder.toString();
    }
}
