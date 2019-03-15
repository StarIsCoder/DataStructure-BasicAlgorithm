package search.algorithm;

public class JumpSearch {
    public int JumpSearch(int arr[], int x) {
        int block = (int) Math.floor(Math.sqrt(arr.length));
        int i = 0;
        while (i < arr.length) {
            if (x > arr[i] && x < arr[i + block]) {
                for (int j = i; j < i + block; j++) {
                    if (arr[j] == x) return j;
                }
            } else {
                i += block;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x = 55;
        JumpSearch jumpSearch = new JumpSearch();

        System.out.println(jumpSearch.JumpSearch(arr, x));
    }
}
