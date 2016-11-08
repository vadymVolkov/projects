package com.volkov.tips;

public class Poor implements Tips {
    public int tips(int sum) {
        return sum + (sum/100*5);
    }
}
