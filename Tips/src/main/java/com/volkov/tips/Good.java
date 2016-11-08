package com.volkov.tips;

public class Good implements Tips {
    public int tips(int sum) {
        return  sum + (sum/100*10);
    }
}
