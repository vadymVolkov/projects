import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibanachiTest {

    @Test
    public void checkOfNumber() {
        int index = 6;
        int result = Fibanachi.checkValue(index);
        assertThat(result, is(8));
    }
}
