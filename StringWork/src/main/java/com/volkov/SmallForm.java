package com.volkov;

public class SmallForm {
    public static void main(String[] args) {
        String text = "internationalization localization cat elephant monitor";
        System.out.println(reduceAll(text));
    }

    public static String reduce(String str) {
        if (str.length() > 4) {
            String length = str.valueOf(str.length() - 2);
            String charFirst = str.valueOf(str.charAt(0));
            String charLast = str.valueOf(str.charAt(str.length() - 1));
            String result = charFirst + length + charLast;
            return result;
        } else {
            return str;
        }
    }

    public static String reduceAll(String str) {
        String result = "";
        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = reduce(strArray[i]);
        }
        for (String s : strArray) {
            result = result + s + " ";
        }
        return result;
    }
}
