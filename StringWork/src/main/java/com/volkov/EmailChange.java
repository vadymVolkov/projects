package com.volkov;

public class EmailChange {
    public static void main(String[] args) {
        String str = "test@gmail.com";
        System.out.println(changeEmail(str));

    }

    public static String changeEmail(String str) {
        String result;
        result = str.replace("@", "[at]");
        result = result.replace(".", "[dot]");
        return result;
    }
}
