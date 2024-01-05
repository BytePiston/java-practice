package Problems;

import java.util.Arrays;

public class MergeSortWithoutExtraSpace {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 4, 1, 7, 3};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                int value = arr[j];
                int index = j;
                while (index != i) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[i] = value;
                i++;
                j++;
            }
        }
    }
}
