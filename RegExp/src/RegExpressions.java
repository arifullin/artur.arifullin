import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpressions {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-z0-9-_]{1,30}@[a-zA-z0-9]{1,10}\\.[a-z]{2,3}");
        try (BufferedReader br = new BufferedReader(new FileReader("in.txt"))){
            while (br.ready()){
                String ss = br.readLine();
                String[] sss = ss.split("\\s");
                for (String i : sss){
                    Matcher matcher = pattern.matcher(i);
                    if (matcher.matches()){
                        System.out.println(i);
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