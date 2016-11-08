import java.util.Iterator;

public interface CustomList {

    int size();
    boolean isEmpty();
    boolean contains(String elements);
    boolean add (String elements);
    void add(int index, String elements);
    boolean remove (int index);
    void clear();
    String get(int index);
    String get(int index, String elements);
    Iterator listIterator();
    Iterator backwardIterator();
    Iterator randomIterator();
    void mix();
}
