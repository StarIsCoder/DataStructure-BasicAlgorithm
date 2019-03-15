package Utils;

public class ArrayUtils {
    public static int[] generateUnsortedArray(int length) {
        int array[] = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);

        }
        return array;
    }
}
