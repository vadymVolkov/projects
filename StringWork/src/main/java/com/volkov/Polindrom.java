package com.volkov;

public class Polindrom {
    public static void main(String[] args) {
        String str = "deleveled";
        String str2 = "deleveled, evitative, cat, dog, deified";
        boolean result = polindromCheck(str);
        System.out.println(result);
        int result2 = polindromCalculate(str2);
        System.out.println("There are " + result2 + " palindromes in the text");
    }

    public static boolean polindromCheck(String str) {
        char[] charArray = str.toCharArray();
        String str2 = "";
        for (int i = charArray.length - 1; i > -1; i--) {
            str2 = str2 + String.valueOf(charArray[i]);
        }
        return str.equals(str2);
    }

    public static int polindromCalculate(String str) {
        String[] strArray = str.split(",");
        int counter = 0;
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].trim();
            if (polindromCheck(strArray[i])) {
                counter++;
            }
        }
        return counter;
    }
}
