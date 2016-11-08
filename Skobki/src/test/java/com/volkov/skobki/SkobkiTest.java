package com.volkov.skobki;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SkobkiTest {
    String input1;
    char charTest1;
    char charTest2;
    @Before
    public void setUp() {

        input1 = "((({}()[])))";
        charTest1= ']';
        charTest2='[';
    }

    @Test
    public void checkIfCloseTest() {
        assertThat(Skobki.checkIfClose(charTest1), is(true));
    }
    @Test
    public void checkIfCloseSkobIsCorrectTest() {
        assertThat(Skobki.checkIfCloseSkobIsCorrect(charTest1,charTest2), is(true));
    }

    @Test
    public void checkIfBalanseTest() {
        assertThat(Skobki.checkIfBalanse(input1), is(true));
    }

}
