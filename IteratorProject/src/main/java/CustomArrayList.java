import java.util.Iterator;
import java.util.Random;

public class CustomArrayList implements CustomList {

    public static int SIZE = 10;
    private String[] array;
    private int size = 0;

    public CustomArrayList() {
        this(SIZE);
    }

    public CustomArrayList(int size) {
        array = new String[size];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String elements) {
        for (int i = 0; i < size; i++) {
            if (elements == array[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean add(String elements) {
        if (size >= array.length)
            resize();
        array[size] = elements;
        size++;
        return true;
    }

    public void add(int index, String elements) {

    }

    private void resize() {
        String[] arrayExt = new String[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            arrayExt[i] = array[i];
        }
        array = arrayExt;
    }

    public boolean remove(int index) {
        for (int i = index - 1; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    public void mix() {
        String[] arrayTemp = new String[size];
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            int randomNum = rnd.nextInt(size);
            if (arrayTemp[randomNum] == null) {
                arrayTemp[randomNum] = array[i];
            } else {
                i--;
            }
        }
    }

    public void clear() {

    }

    public String get(int index) {
        return null;
    }

    public String get(int index, String elements) {
        return null;
    }

    public Iterator listIterator() {
        return new ListIterator();
    }

    public Iterator backwardIterator() {
        return new BackwardIterator();
    }

    public Iterator randomIterator() {
        return new RandomIterator();
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i != 0)
                result += ", ";
            result += array[i];
        }

        result += "]";
        return result;
    }

    private class ListIterator implements Iterator {

        int current = 0;

        public boolean hasNext() {
            return current < size;
        }

        public Object next() {
            String element = array[current];
            current++;
            return element;
        }
    }

    private class BackwardIterator implements Iterator {

        int current = size - 1;

        public boolean hasNext() {
            return current >= 0;
        }

        public Object next() {
            String element = array[current];
            current--;
            return element;
        }
    }

    private class RandomIterator implements Iterator {
        String[] arrayTemp = new String[size];
        public RandomIterator() {
            for (int i = 0; i <array.length ; i++) {
                arrayTemp[i]=array[i];
            }
        }

        int counter = 0;



        public boolean hasNext() {
            return counter < size;
        }

        public Object next() {
            Random rnd = new Random();
            int random = rnd.nextInt(arrayTemp.length);
            String element;
            element = arrayTemp[random];
            counter++;
            arrayTemp=removeRendomElement(arrayTemp,random);
            return element;
        }
        public String[] removeRendomElement (String[] arrayTemp , int element) {
            for (int i = element; i < arrayTemp.length - 1; i++) {
                arrayTemp[i] = arrayTemp[i + 1];
            }
            String[] arrayMinusOneElement = new String[arrayTemp.length-1];
            for (int i = 0; i <arrayMinusOneElement.length ; i++) {
                arrayMinusOneElement[i]=arrayTemp[i];
            }
            return arrayMinusOneElement;

        }
    }
}
