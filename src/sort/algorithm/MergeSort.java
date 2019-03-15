package sort.algorithm;

import Utils.ArrayUtils;

public class MergeSort {
    public void merge(int arr[], int l, int m, int r) {
        int tmp[] = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= m) {
            tmp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= r) {
            tmp[k] = arr[j];
            j++;
            k++;
        }

        for (i = l; i <= r; i++) {
            arr[i] = tmp[i - l];
        }
    }

    public void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int tmp[] = ArrayUtils.generateUnsortedArray(10);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
        System.out.println();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(tmp, 0, tmp.length - 1);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }

}
