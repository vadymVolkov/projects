package com.sort;

public class Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{9, 8, 3, 1, 4, 99, 14, 2, 1, 6, 7, 8, 2, 3, 55, 11, 67, 121, 2223, 1, 6778, 1, 98};
        array1 = Sort.sortArray(array1);
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }

    public static int[] sortArray(int[] array) {
        if (array.length == 1) {
            return array;
        } else {
            int midle = array.length / 2;
            int[] array1 = new int[midle];
            int[] array2 = new int[array.length - midle];
            for (int i = 0; i < array.length; i++) {
                if (i < midle) {
                    array1[i] = array[i];
                }
                if (i > midle - 1) {
                    array2[i - midle] = array[i];
                }
            }
            return Merge.mergeTwoArray(sortArray(array1), sortArray(array2));
        }
    }
}
