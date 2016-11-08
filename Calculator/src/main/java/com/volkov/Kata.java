package com.volkov;

import java.util.ArrayList;

public class Kata {
    public static int TripleDouble(long num1, long num2) {
        int result = 0;
        int counter1 = 0;
        int counter2 = 0;
        long check1 = 0;
        long check2 = 0;
        ArrayList<Long> list1 = new ArrayList<Long>();
        ArrayList<Long> list2 = new ArrayList<Long>();
        for (int i = 0; num1 > 1; i++) {
            list1.add(num1 % 10);
            num1 = num1 / 10;
        }
        for (int i = 0; num2 > 1; i++) {
            list2.add(num2 % 10);
            num2 = num2 / 10;
        }
        for (int i = 2; i < list1.size(); i++) {
            if (list1.get(i) == list1.get(i - 1) && list1.get(i) == list1.get(i - 2)) {
                counter1++;
                check1 = list1.get(i);
            }
        }
        for (int i = 1; i < list2.size(); i++) {
            if (list2.get(i) == list2.get(i - 1) && list2.get(i) == check1) {
                counter2++;
                check2 = list2.get(i);
            }
        }
        if (check1 == check2 && counter1 > 0 && counter2 > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        long a = 451999277;
        long b = 1177722899;
        System.out.println(Kata.TripleDouble(a, b));
    }
}
