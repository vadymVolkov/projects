package com.volkov;

import java.math.BigInteger;

public class Kata3 {
    public static BigInteger finance(int n) {
        // your code
        int counter1 = n+1;
        int counter2 = n+1;
        BigInteger totalMoney= BigInteger.valueOf(0);
        int money= 0;
        int moneyStable= 2;
        for (int j = 0; j <counter1; j++) {
            for (int i = 0; i < counter2; i++) {
                totalMoney=totalMoney.add(BigInteger.valueOf(money));
                money++;
            }
            money=moneyStable;
            moneyStable=moneyStable+2;
            counter2--;
        }
        return totalMoney;
    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println(Kata3.finance(num));
    }
}
