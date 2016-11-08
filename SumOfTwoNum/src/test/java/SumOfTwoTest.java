import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SumOfTwoTest {
    @Test
    public void test() {
        int[] array = {1, 3, 5, 9, 16};
        int num = 4;
        boolean result = SumOfTwo.Check(array, 4);
        assertThat(result, is(true));
    }
}
