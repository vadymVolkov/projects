package com.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortTest {
    @Test
    public void SortLastBigerFirst() {
        int[] array1 = new int[]{9, 8, 3, 1, 4};
        array1=Sort.sortArray(array1);
        assertThat(array1[0]<array1[array1.length-1],is(true));
    }
}
