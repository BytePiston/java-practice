package Problems;

import java.util.Arrays;

public class MergeSortWithExtraSpace {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 1, 5, 4, 1, 7, 3})));
    }

    private static int[] mergeSort(int[] nums) {
        if (nums.length<=1) {
            return nums;
        }
        int mid = (nums.length)/2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return mergeArrays(left, right);
    }

    private static int[] mergeArrays(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left] <= rightArray[right]) {
                mergedArray[index] = leftArray[left];
                left++;
            } else {
                mergedArray[index] = rightArray[right];
                right++;
            }
            index++;
        }
        while (left < leftArray.length) {
            mergedArray[index] = leftArray[left];
            left++;
            index++;
        }
        while (right < rightArray.length) {
            mergedArray[index] = rightArray[right];
            right++;
            index++;
        }
        return mergedArray;
    }
}
