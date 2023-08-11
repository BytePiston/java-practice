package dynamic_programming;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 * <p>
 * Write a function 'canSum(targetSum, arrayNumbers)' that takes in targetSum and an array of numbers as arguments.
 * <p>
 * The function should return a boolean indicating whether it is possible to generate the targetSum using numbers from the array.
 * <p>
 * You may use an element of the array as many times as needed.
 * <p>
 * You may assume that all input numbers are non-negative.
 * <p>
 * Example:
 * <p>
 * canSum(7, [5, 3, 4,7])  --> true; 7, 3+4
 * canSum(7, [2, 4])  --> false;
 */
public class CanSum {

    /**
     * @param targetSum -> The number for which computation will be performed.
     *                  numbers -> Array if numbers which will be used to check the targetSum.
     * @return boolean -> Returns True if targetSum number can be formed by adding any element from given array.
     * Returns False if targetSum number can not be formed.
     * Approach 1: We will subtract the targetSum and element of array recursively to see if we find 0 at the leaf node.
     * If at the leaf node 0 is found meaning that path adds up to the targetSum value else return false.
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n^m)
     * Space Complexity -> O(m)
     */
    public boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0)
            return true;
        else if (targetSum < 0)
            return false;
        for (int number : numbers) {
            int remainder = targetSum - number;
            if (canSum(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> Array of numbers which will be used to check the targetSum.
     * @return -> Returns True if targetSum number can be formed by adding any element from given array.
     * Returns False if targetSum number can not be formed.
     * Approach 2: We will subtract the targetSum and element of array recursively to see if we find 0 at the leaf node.
     * If at the leaf node 0 is found meaning that path adds up to the targetSum, so we will add it to the memo HashMap to keep track of sub-trie value else return false.
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n*m)
     * Space Complexity -> O(m)
     */
    public boolean memoizedCanSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;
        for (int number : numbers) {
            int remainder = targetSum - number;
            if (memoizedCanSum(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> Array of numbers which will be used to check the targetSum.
     * @return -> Returns True if targetSum number can be formed by adding any element from given array.
     * Returns False if targetSum number can not be formed.
     * Approach 3: We will create a tab array with size targetSum+1 of boolean type and with initial value as False.
     * For each index of the array it represents whether it is possible to create that number using given numbers array.
     * Example: Value at index 1 be it True/False represents whether we can create that number using values from numbers array.
     * and then we will update arr[0] to True since it is our base case where we can always create 0 as we will not need to pick any elements
     * from the numbers array. We will have 2 loops 1 outer loop which will loop through all the indexes of tab array
     * and 1 inner loop which will iterate through all the elements of the numbers array.
     * <p>
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n*m)
     * Space Complexity -> O(m)
     */
    public boolean tabulizedCanSum(int targetSum, int[] numbers) {
        boolean[] tab = new boolean[targetSum + 1];
        tab[0] = true;
        for (int i = 0; i < targetSum; i++) {
            if (tab[i]) {
                for (int num : numbers) {
                    if (i + num <= targetSum)
                        tab[i + num] = tab[i];
                }
            }
        }
        return tab[targetSum];
    }

    public long computeTimeCanSum(int targetSum, int[] numbers) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        boolean ans = canSum(targetSum, numbers);
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }

    public long computeTimeMemoizedCanSum(int targetSum, int[] numbers) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        boolean ans = memoizedCanSum(targetSum, numbers, new HashMap<>());
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }

}
