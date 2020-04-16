package sort.algorithm;

public class ShellSort {
    public void shellSort(int[] input) {
        int size = input.length;
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i += gap) {
                int tmp = input[i];
                int j;
                for (j = i; j >= gap && tmp < input[j - gap]; j -= gap) {
                    input[j] = input[j - gap];
                }
                input[j] = tmp;
            }
        }
    }
}
