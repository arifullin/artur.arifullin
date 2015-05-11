package ru.kpfu.group11403.arifullin;

import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> inside;
    public MyStack(){
        inside = new ArrayList<T>();
    }
    public void push(T x){
        inside.add(x);
    }
    public T pop(){
       return inside.remove(inside.size()-1);
    }
    public T peek(){
        return inside.get(inside.size()-1);
    }
    public boolean empty(){
        return inside.size() == 0;
    }

}
