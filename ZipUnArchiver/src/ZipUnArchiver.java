package ru.kpfu.group403.arifullin;

import java.io.*;
import java.util.zip.ZipInputStream;

public class ZipUnArchiver {
    public static void main(String[] args) {
        byte[] x = new byte[256];
        try (ZipInputStream inputZip = new ZipInputStream(new BufferedInputStream(new FileInputStream("in.zip")))){
            int count = 0;
            while (null!=inputZip.getNextEntry()){
                count++;
                String copyName = new String("copy"+count+".txt");
                while (!(inputZip.read(x) == -1)){
                    try (DataOutputStream copyCreate = new DataOutputStream(new FileOutputStream(copyName))){
                        copyCreate.write(x);
                        copyCreate.flush();
                    } catch (FileNotFoundException e) {
                        System.out.println("upsssss");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Zip not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
