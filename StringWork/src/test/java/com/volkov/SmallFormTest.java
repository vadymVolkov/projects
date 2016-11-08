package com.volkov;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SmallFormTest {

    @Test
    public void lengthTestForReduce() {
        String str = "internationalization";
        String result = SmallForm.reduce(str);
        assertThat(result.length() <= 4, is(true));
    }

    @Test
    public void lengthTestForReduceAll() {
        boolean result = true;
        String str = "internationalization localization cat elephant monitor";
        String reducedText = SmallForm.reduceAll(str);
        String[] reducedTextArray = reducedText.split(" ");
        for (int i = 0; i < reducedTextArray.length; i++) {
            if (reducedTextArray[i].length() > 4) {
                result = false;
            }
        }
        assertThat(result, is(true));
    }
}
