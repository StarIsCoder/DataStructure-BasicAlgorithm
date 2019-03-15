package sort.algorithm;

import Utils.ArrayUtils;

public class SelectionSort {
    public void selectionSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int min_index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            int tmp = array[min_index];
            array[min_index] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int tmp[] = ArrayUtils.generateUnsortedArray(10);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
        System.out.println();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(tmp);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }
}
