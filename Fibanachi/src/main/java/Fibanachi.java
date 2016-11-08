public class Fibanachi {
    static int counter=0;
    public static void main(String[] args) {
        int index = 8;
        int result = checkValue(index);
        System.out.println(result);
        System.out.println(counter);
    }

    public static int checkValue(int index) {

        counter++;

        if (index == 0) {
            return 0;
        }
        if (index == 1 || index == 2) {
            return 1;
        } else {
            return checkValue(index - 2) + checkValue(index - 1);
        }
    }
}
