package com.volkov;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PolindromTest {
    @Test
    public void PolindromCheckTest() {
        String str = "deleveled";
        boolean result = Polindrom.polindromCheck(str);
        assertThat (result, is(true));

    }
    @Test
    public void PolindromCalculateTest() {
        String str = "deleveled, evitative, cat, dog, deified";
        int result = Polindrom.polindromCalculate(str);
        assertThat (result, is(3));

    }
}
