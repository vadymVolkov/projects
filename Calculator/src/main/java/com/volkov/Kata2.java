package com.volkov;

import java.util.ArrayList;

public class Kata2 {
    public static int sortDesc(final int num) {
        //Your code
        int num1 = num;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; num1 > 0; i++) {
            list.add(num1 % 10);
            num1 = num1 / 10;
        }
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(0);
            int b = list.get(0);
            for (int j = 0; j < list.size()-1; j++) {
                if (a < list.get(j+1)) {
                    a = list.get(j);
                    b = list.get(j + 1);
                    list.set(j, b);
                    list.set(j + 1, a);
                }
                else {
                    a=list.get(j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i==list.size()-1) {
                result = result + list.get(i);
            }
            else {
                result = result + list.get(i);
                result = result*10;
            }
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));

        }
        return result;
    }

    public static void main(String[] args) {
        int a = 123456789;
        System.out.println(Kata2.sortDesc(a));
    }
}
