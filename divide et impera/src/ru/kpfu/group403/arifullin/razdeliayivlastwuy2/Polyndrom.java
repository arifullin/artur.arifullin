package ru.kpfu.group403.arifullin.razdeliayivlastwuy2;

public class Polyndrom {
    StringBuilder copy;
    public boolean isPol(String x){
        copy = new StringBuilder(x);
        if (copy.length() == 0 || copy.length() == 1) {
            return true;
        }
        if (copy.charAt(0) != copy.charAt(copy.length()-1)) {
            return false;
        }else {
            copy.deleteCharAt(0);
            copy.deleteCharAt(copy.length() - 1);
            return isPol(copy.toString());
        }
    }
}
