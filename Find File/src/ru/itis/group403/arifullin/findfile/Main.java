package ru.itis.group403.arifullin.findfile;

import java.io.File;

public class Main {
    boolean v = false;
    boolean recursive = false;
    int deep;
    String startPath = null;
    String template = null;
    private void checkargs(String[] x){
        for(int i = 0;i < x.length;i++){
            if (x[i].equals("-v")){
                v = true;
            }else if (x[i].equals("-r")){
                recursive = true;
            }else if ((x[i].charAt(0) == '-') && (x[i].charAt(1) == 'd')) {
                try{
                        deep = Integer.parseInt(x[i].substring(2));
                    }catch (NumberFormatException e){
                        System.out.println("Вводи корректно,глубина это число");
                        System.exit(0);
                    }
            }else if (x[i].startsWith(":/",1)){
                startPath = new String(x[i]);
            }else {
                template = new String(x[i]);
            }
        }
        if ((deep != 0)&&(recursive == true)){
            System.out.println("Либо рекурсивный посик,либо глубинный,не пиши их вместе,вооот...");
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        Main lolipop = new Main();
        lolipop.checkargs(args);

       /* File f = null;
        f = new File("C:/Users/хэтфилд/Desktop");
        File[] a;
        a = f.listFiles();
        int i = 0;
        for (File path:a){
            i++;
            System.out.println(i+"."+path);
        }*/

    }

}
