import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUnArchiver {
    public static void main(String[] args) {
        byte[] x = new byte[200000];
        try (ZipInputStream a = new ZipInputStream(new BufferedInputStream(new FileInputStream("in.zip")))){
            while (null!=a.getNextEntry()){
            while (!(a.read(x) == -1)){
                try (DataOutputStream b = new DataOutputStream(new FileOutputStream("copy.txt"))){
                    b.write(x);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
