package com.volkov.tips;

public class Excellent implements Tips {
    public int tips(int sum) {
        return sum + (sum/100*20);
    }
}
