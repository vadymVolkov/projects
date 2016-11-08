public class FibanachiWithoutRecursion {
    static int counter=0;
    public static void main(String[] args) {
        int index = 10;
        int result = checkValue(index);
        System.out.println(result);
        System.out.println(counter);
    }

    public static int checkValue(int index) {
        if (index == 0) {
            return 0;
        }
        int[] array = new int[index];
        for (int i = 0; i < array.length; i++) {
            counter++;
            if (i == 0 || i == 1) {
                array[i] = 1;
            } else {
                array[i] = array[i - 2] + array[i - 1];
            }
        }
        return array[index - 1];
    }
}
