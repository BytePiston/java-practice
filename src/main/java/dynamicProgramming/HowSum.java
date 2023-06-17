package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Problem Statement:
 * <p>
 * Write a function 'howSum(targetSum, arrayNumbers)' that takes in targetSum and an array of numbers as arguments.
 * <p>
 * The function should return a array indicating how it is possible to generate the targetSum using numbers from the array.
 * <p>
 * You may use an element of the array as many times as needed.
 * <p>
 * You may assume that all input numbers are non-negative.
 * <p>
 * Example:
 * <p>
 * howSum(7, [5, 3, 4,7])  -->  [7], [3,4]
 * howSum(7, [2, 4])  --> [];
 * howSum(0, [2, 4])  --> [];
 */
public class HowSum {

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> Array if numbers which will be used to check the targetSum.
     * @return -> Returns List of numbers which is the path taken to form targetSum else return empty List.
     * <p>
     * Approach 1: We will subtract the targetSum and element of array recursively to see if we find 0 at the leaf node.
     * If at the leaf node 0 is found meaning that path adds up to the targetSum value so will add this number to output List else return empty List.
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n^m * m)
     * Space Complexity -> O(m)
     */
    public List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        for (int number : numbers) {
            int remainder = targetSum - number;
            List<Integer> remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
                remainderResult.add(number);
                return remainderResult;
            }

        }
        return null;
    }

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> List of numbers which will be used to check the targetSum.
     * @return ->Returns List of numbers which is the path taken to form targetSum else return empty List.
     * <p>
     * Approach 2: We will subtract the targetSum and element of array recursively to see if we find 0 at the leaf node.
     * If at the leaf node 0 is found meaning that path adds up to the targetSum, so will add this number to output List also we will add it to the memo HashMap to keep track of sub-trie value else return empty List.
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n*m^2)
     * Space Complexity -> O(m^2)
     */
    public List<Integer> memoizedHowSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum) && memo.get(targetSum) != null)
            return memo.get(targetSum);
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        for (int number : numbers) {
            int remainder = targetSum - number;
            List<Integer> remainderResult = memoizedHowSum(remainder, numbers, memo);
            if (remainderResult != null) {
                remainderResult.add(number);
                memo.put(targetSum, remainderResult);
                return remainderResult;
            }

        }
        memo.put(targetSum, null);
        return null;
    }
}