import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibanachiWithoutRecursionTest {
    @Test
    public void checkOfNumber() {
        int index = 6;
        int result = FibanachiWithoutRecursion.checkValue(index);
        assertThat(result, is(8));
    }
}
