package sort.algorithm;

public class QuickSort {
    public int partition(int input[], int low, int high) {
        int pivot = input[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (input[j] < pivot) {
                i++;

                int tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
            }
        }
        int tmp = input[i + 1];
        input[i + 1] = input[high];
        input[high] = tmp;
        return i + 1;
    }

    public void quickSort(int input[], int low, int high) {
        if (low < high) {
            int pi = partition(input, low, high);

            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
    }

    public void sortByTwoPointer(int input[], int low, int high) {
        if (low > high) return;
        int start = low;
        int end = high;
        int pivot = input[low];
        while (start < end) {
            while (start < end && input[end] >= pivot) {
                end--;
            }
            while (start < end && input[start] <= pivot) {
                start++;
            }
            if (start < end) {
                int tmp = input[start];
                input[start] = input[end];
                input[end] = tmp;
            }
        }
        input[low] = input[start];
        input[start] = pivot;

        sortByTwoPointer(input, start + 1, high);
        sortByTwoPointer(input, low, start - 1);
    }
}
