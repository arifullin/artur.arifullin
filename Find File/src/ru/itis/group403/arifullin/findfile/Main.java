package ru.itis.group403.arifullin.findfile;

import java.io.File;

public class Main {
    boolean v = false;
    boolean recursive = false;
    int deep;
    String startPath = null;
    String template = null;
    private void find(String[] x){
        checkArgs(x);
        File start = new File(startPath);

        if (!(start.isDirectory())){
            System.out.println("Не правильная директория");
            System.exit(0);
        }
        if (recursive == true){
            recuriveSearch(start);
        }else if (deep > 0){
            deepSearch(start,++deep);
        }else if (deep <0){
            System.out.println("Fck you");
        }else{
            deep++;
            deepSearch(start,deep);
        }
    }
    private void checkArgs(String[] x){
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
            System.out.println("Либо рекурсивный поиск,либо глубинный,не пиши их вместе,вооот...");
            System.exit(0);
        }
    }
    private void recuriveSearch(File x){
        File[] folder;
        folder = x.listFiles();
        for (int i = 0; i < folder.length; i++) {
            if (folder[i].getName().contains(template)){
                if (v == true){
                    System.out.println(folder[i]);
                }else {
                    if (!(folder[i].isDirectory())){
                        System.out.println(folder[i]);
                    }
                }
            }
            if (folder[i].isDirectory()){
                recuriveSearch(folder[i]);
            }
        }
    }
    private void deepSearch(File x,int j){
        if (j <= 0){
            return ;
        }
        File[] folder;
        folder = x.listFiles();
        for (int i = 0; i < folder.length; i++) {
            if (folder[i].getName().contains(template)) {
                if (v == true) {
                    System.out.println(folder[i]);
                } else {
                    if (!(folder[i].isDirectory())) {
                        System.out.println(folder[i]);
                    }
                }
            }
            if (folder[i].isDirectory()){
                    int a = j - 1;

                    deepSearch(folder[i],a);
            }
        }

    }


    public static void main(String[] args) {
        Main lolipop = new Main();
        lolipop.find(args);
    }

}
