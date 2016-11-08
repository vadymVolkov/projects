package com.volkov.skobki;

import java.util.Stack;

public class Skobki {
    public static boolean checkIfClose(char c) {
        String str = ")}]>";
        char[] myChar = str.toCharArray();
        boolean result = false;
        for (int i = 0; i < myChar.length; i++) {
            if (myChar[i] == c) {
                result = true;
            }
        }
        return result;
    }

    public static boolean checkIfCloseSkobIsCorrect(char a, char b) {
        int c = a - b;
        if (c == 1 || c == 2) {
            return true;
        }
        return false;
    }

    public static boolean checkIfBalanse(String str) {
        char[] myChar = str.toCharArray();

        if (checkIfClose(myChar[0])) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        stack.push(myChar[0]);

        for (int i = 1; i < myChar.length; i++) {
            char a = myChar[i];
            char b =  stack.peek();
            if (checkIfClose(myChar[i])) {
                if (checkIfCloseSkobIsCorrect(a, b)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(a);
            }
        }
        return stack.empty();
    }
}
