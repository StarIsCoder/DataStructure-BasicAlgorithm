package sort.algorithm;

import Utils.ArrayUtils;

public class InsertionSort {
    public void InsertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int tmp[] = ArrayUtils.generateUnsortedArray(10);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
        System.out.println();
        InsertionSort insertionSort = new InsertionSort();

        insertionSort.InsertionSort(tmp);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }
}
