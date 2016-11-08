package com.volkov.tips;

public class TipsMain {
    public static void main(String[] args) {
        Tips terrible = new Terrible();
        Tips poor = new Poor();
        Tips good = new Good();
        Tips great = new Great();
        Tips excellent = new Excellent();
        int totallSumToPay = 100;
        System.out.println("If service was terrible you nedd to pay  " +terrible.tips(totallSumToPay));
        System.out.println("If service was poor you nedd to pay  " +poor.tips(totallSumToPay));
        System.out.println("If service was good you nedd to pay  " +good.tips(totallSumToPay));
        System.out.println("If service was great you nedd to pay  " +great.tips(totallSumToPay));
        System.out.println("If service was excellent you nedd to pay  " +excellent.tips(totallSumToPay));
    }
}
