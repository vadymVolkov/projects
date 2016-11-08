public class Merge {
    public static int[] merged(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int[] result = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < length1 && j < length2) {
            if (array1[i] < array2[j]) {
                result[index] = array1[i];
                i++;
            } else {
                result[index] = array2[j];
                j++;
            }
            index++;
        }
        while (i < length1) {
            result[index] = array1[i];
            i++;
            index++;
        }
        while (j < length2) {
            result[index] = array2[j];
            j++;
            index++;
        }
        return result;
    }
}
