package dynamicProgramming;

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
//                System.out.println(number);  --> if we want to print the numbers which were used then print this.
                return true;
            }
        }
        return false;
    }

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> Array if numbers which will be used to check the targetSum.
     *                  numbers
     * @return boolean -> Returns True if targetSum number can be formed by adding any element from given array.
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
