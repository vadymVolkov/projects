package com.volkov.skobki;

public class Main {
    public static void main(String[] args) {


        String input1 = "((({}()[])))";
        String input2 = "(({)})";
        String input3 = "{([])}";
        String input4 = "()";


        System.out.println(Skobki.checkIfBalanse(input1));
        System.out.println(Skobki.checkIfBalanse(input2));
        System.out.println(Skobki.checkIfBalanse(input3));
        System.out.println(Skobki.checkIfBalanse(input4));


    }

}
