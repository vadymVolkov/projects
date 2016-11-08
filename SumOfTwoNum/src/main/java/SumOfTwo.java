public class SumOfTwo {
    public static boolean Check(int[] a, int num) {
        boolean result = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] + a[j] == num) {
                    result = true;
                }
            }
        }
        return result;
    }
}
