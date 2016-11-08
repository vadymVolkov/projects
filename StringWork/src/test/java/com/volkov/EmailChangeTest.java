package com.volkov;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmailChangeTest {
    String str;
    boolean result;

    @Before
    public void setUp() {
        str = "test@gmail.com";
        str = EmailChange.changeEmail(str);
        result = true;
    }

    @Test
    public void AtCheck() {
        for (char s : str.toCharArray()) {
            if (s == '@') {
                result = false;
            }
        }
        assertThat(result, is(true));
    }

    @Test
    public void DotCheck() {
        for (char s : str.toCharArray()) {
            if (s == '.') {
                result = false;
            }
        }
        assertThat(result, is(true));
    }
}
