package ru.kpfu.group11403.arifullin;

import java.util.Scanner;

public class BracketsChecker {
    public static void main(String[] args) {
        int firstType = 0;
        int secondType = 0;
        int thirdType = 0;
        String expression;
        MyStack stack = new MyStack();
        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();
        for (int i = 0; i < expression.length(); i++) {
            stack.push(expression.charAt(i));
        }
        while (!stack.empty()&&firstType<=0&&secondType<=0&&thirdType<=0){
            if (stack.peek().equals('(')){
                firstType++;
            }else if (stack.peek().equals(')')){
                firstType--;
            }else if (stack.peek().equals('{')){
                secondType++;
            }else if (stack.peek().equals('}')){
                secondType--;
            }else if (stack.peek().equals('[')){
                thirdType++;
            }else if (stack.peek().equals(']')){
                thirdType--;
            }
            stack.pop();
        }
        if (firstType == 0&&secondType == 0&&thirdType==0){
            System.out.println("Correct");
        }else {
            System.out.println("Incorect");
        }
    }
}
