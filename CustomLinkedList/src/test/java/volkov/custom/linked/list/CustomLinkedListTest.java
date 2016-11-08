package volkov.custom.linked.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomLinkedListTest {

    CustomLinkedList list;

    @Before
    public void setUp() {
        list = new CustomLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
    }

    @Test
    public void hasCycleTest(){
        list.introduceCycle(4);
        assertThat(list.hasCycle(),is(true));
    }
    @Test
    public void sizeTest(){
        assertThat(list.size(),is(9));
    }
    @Test
    public void findElementTest(){
        assertThat(list.findElement(2),is("h"));
    }
}
