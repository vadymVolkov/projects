import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MergeTest {
    int[] array1;
    int[] array2;
    int[] result;

    @Before
    public void setUp() {
        array1 = new int[]{1, 2, 3, 4, 5};
        array2 = new int[]{6, 7, 8, 9, 10};
        result = Merge.merged(array1, array2);
    }

    @Test
    public void lengthTest() {
        assertThat(result.length, is(10));
    }

    @Test
    public void checkMinAndMax() {
        assertThat(result[0] < result[9], is(true));
    }

    @Test
    public void checkCorrectSortOfArray() {
        boolean check = true;
        for (int i = 1; i < result.length; i++) {
            if (result[i] < result[i-1]) {
                check=false;
            }
        }
        assertThat(check,is(true));
    }
}
