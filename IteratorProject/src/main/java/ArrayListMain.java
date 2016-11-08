import java.util.Iterator;

public class ArrayListMain {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(5);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("j");
        list.add("h");
        list.add("i");
        list.add("g");


        System.out.println(" ");
        Iterator randomIterator = list.randomIterator();
        while (randomIterator.hasNext()) {
            System.out.println(randomIterator.next());
        }
        System.out.println(" ");
        Iterator backwardIterator = list.backwardIterator();
        while (backwardIterator.hasNext()) {
            System.out.println(backwardIterator.next());
        }
        Iterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
