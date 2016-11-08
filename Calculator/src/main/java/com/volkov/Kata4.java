package com.volkov;

import java.math.BigInteger;

public class Kata4 {
    public static String stringy(int size) {
        // Your code here
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < size-1; i++) {
            if (i%2==0) {
                result = result.multiply(BigInteger.valueOf(10));
            }
            else {
                result = result.multiply(BigInteger.valueOf(10));
                result=result.add(BigInteger.valueOf(1));
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(Kata4.stringy(6));
    }
}
