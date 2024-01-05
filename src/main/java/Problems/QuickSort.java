package Problems;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 4, 1, 7, 3};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int correctPivotIndex = findCorrectPivotPos(nums, low, high);
            quickSort(nums, low, correctPivotIndex-1);
            quickSort(nums, correctPivotIndex + 1, high);
        }
    }

    private static int findCorrectPivotPos(int[] nums, int low, int high) {
        int pivot = nums[low];
        int left = low;
        int right = high;

        while (left < right) {
            while (left <= high && nums[left] <= pivot) {
                left++;
            }

            while (right >= low && nums[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, low, right);
        return right;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
