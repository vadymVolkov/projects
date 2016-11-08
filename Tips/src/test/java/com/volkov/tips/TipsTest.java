package com.volkov.tips;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TipsTest {
    Tips terrible;
    Tips poor;
    Tips good;
    Tips great;
    Tips excellent;
    int totallSumToPay;
    @Before
    public void setUp() {
        totallSumToPay = 100;
        terrible = new Terrible();
        poor = new Poor();
        good = new Good();
        great = new Great();
        excellent = new Excellent();
    }
    @Test
    public void terribleTest() {
        assertThat(terrible.tips(totallSumToPay), is(100));
    }
    @Test
    public void poorTest() {
        assertThat(poor.tips(totallSumToPay), is(105));
    }
    @Test
    public void goodTest() {
        assertThat(good.tips(totallSumToPay), is(110));
    }
    @Test
    public void greatTest() {
        assertThat(great.tips(totallSumToPay), is(115));
    }
    @Test
    public void excellentTest() {
        assertThat(excellent.tips(totallSumToPay), is(120));
    }

}
