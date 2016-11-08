package com.volkov.tips;

public class Great implements Tips {
    public int tips(int sum) {
        return  sum + (sum/100*15);
    }
}
