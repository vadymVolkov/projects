package com.sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeTest {

    @Test

    public void MergeIsCorrect() {
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{6, 7, 8, 9, 10};
        int[] arrayResult = Merge.mergeTwoArray(array1,array2);
        assertThat(arrayResult.length,is(10));
    }

}
