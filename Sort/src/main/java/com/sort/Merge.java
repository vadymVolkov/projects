package com.sort;

public class Merge {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 5, 7, 9};
        int[] array2 = new int[]{2, 4, 6, 8, 10};
        int[] arrayResult = Merge.mergeTwoArray(array1, array2);
        for (int i = 0; i < arrayResult.length; i++) {
            System.out.println(arrayResult[i]);
        }

    }

    public static int[] mergeTwoArray(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int[] result = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < length1 && j < length2) {
            if (array1[i] < array2[j]) {
                result[index] = array1[i];
                i++;
            } else {
                result[index] = array2[j];
                j++;
            }
            index++;
        }
        while (i < length1) {
            result[index] = array1[i];
            i++;
            index++;
        }
        while (j < length2) {
            result[index] = array2[j];
            j++;
            index++;
        }
        return result;
    }
}
