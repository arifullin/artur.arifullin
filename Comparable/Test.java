import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Appliance[] mas = new Appliance[2];
        mas[1] = new Appliance(1,100,100);
        mas[0] = new Vacum(5,100,100,4);
        int a = mas[0].getRating();
        int b = mas[1].getRating();
        System.out.println(a+"  "+b);
        Arrays.sort(mas);
        a = mas[0].getRating();
        b = mas[1].getRating();
        System.out.println(a+"  "+b);




    }

}
