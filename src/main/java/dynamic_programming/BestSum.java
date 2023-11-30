package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Statement:
 * <p>
 * Write a function 'bestSum(targetSum, arrayNumbers)' that takes in targetSum and an array of numbers as arguments.
 * <p>
 * The function should return a array indicating  the best possible path to generate the targetSum using numbers from the array out of all the paths.
 * <p>
 * You may use an element of the array as many times as needed.
 * <p>
 * You may assume that all input numbers are non-negative.
 * <p>
 * Example:
 * <p>
 * bestSum(7, [5, 3, 4,7])  -->  [7], [3,4]
 * bestSum(7, [2, 4])  --> [];
 * bestSum(0, [2, 4])  --> [];
 */

public class BestSum {

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> Array if numbers which will be used to check the targetSum.
     * @return -> Returns List of numbers which is the best path taken to form targetSum else return empty List.
     * <p>
     * Approach 1: We will subtract the targetSum and element of array recursively to see if we find 0 at the leaf node.
     * If at the leaf node 0 is found meaning that path adds up to the targetSum value so will add this number to output List then compare all list to get the best path else return empty List.
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n^m * m)
     * Space Complexity -> O(m^2)
     */
    public List<Integer> bestSum(int targetSum, int[] numbers) {
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        List<Integer> bestPath = null;
        for (int number : numbers) {
            int remainder = targetSum - number;
            List<Integer> remainderList = bestSum(remainder, numbers);
            if (remainderList != null) {
                remainderList.add(number);
                if (bestPath == null || remainderList.size() < bestPath.size())
                    bestPath = remainderList;
            }
        }
        return bestPath;
    }

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> List of numbers which will be used to check the targetSum.
     * @return -> Returns List of numbers which is the best path taken to form targetSum else return empty List.
     * <p>
     * Approach 2: We will subtract the targetSum and element of array recursively to see if we find 0 at the leaf node.
     * If at the leaf node 0 is found meaning that path adds up to the targetSum, so will add this number to output List and compare it to find the best path also we will add it to the memo HashMap to keep track of sub-trie value else return empty List.
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n*m^2)
     * Space Complexity -> O(m^2)
     */

    public static void main(String[] args) {
        System.out.println(memoizedBestSum(11, new int[]{1,2,5}, new HashMap<>()).size());
    }


    public static List<Integer> memoizedBestSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        List<Integer> bestPath = null;
        for (int number : numbers) {
            int remainder = targetSum - number;
            List<Integer> remainderList = memoizedBestSum(remainder, numbers, memo);
            if (remainderList != null) {
                remainderList = new ArrayList<>(remainderList); // Create a new list for each iteration
                remainderList.add(number);
                if (bestPath == null || remainderList.size() < bestPath.size())
                    bestPath = remainderList;
            }
        }
        memo.put(targetSum, bestPath);
        return bestPath;
    }

    /**
     * @param targetSum -> The number for which computation will be performed.
     * @param numbers   -> Array of numbers which will be used to check the targetSum.
     * @return -> Returns array of the best path which is the shortest path to form targetSum number by adding any element from given array.
     * Returns Null if targetSum number can not be formed.
     * Approach 3: We will create a tab array with size targetSum+1 of List<Integer> type and with initial value as Null.
     * For each index of the array it represents whether it is possible to create that number using given numbers array.
     * Example: Value at index 1 be it Null or List of Integers represents whether we can create that number using values from numbers array.
     * and then we will update arr[0] to Empty List [], since it is our base case where we can always create 0 as we will not need to pick any elements
     * from the numbers array. We will have 2 loops 1 outer loop which will loop through all the indexes of tab array
     * and 1 inner loop which will iterate through all the elements of the numbers array.
     * <p>
     * m --> targetSum
     * n --> number of element in array
     * Time Complexity -> O(n*m)
     * Space Complexity -> O(m)
     */
    public List<Integer> tabulizedBestSum(int targetSum, int[] numbers) {
        List<Integer>[] tab = (List<Integer>[]) new ArrayList[targetSum + 1];
        tab[0] = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++) {
            if (tab[i] != null) {
                for (int num : numbers) {
                    if (i + num <= targetSum) {
                        List<Integer> newList = new ArrayList<>(tab[i]);
                        newList.add(num);
                        if(tab[i+num] == null || tab[i+num].size() >= newList.size())
                            tab[i+num] = newList;
                    }
                }
            }
        }
        return tab[targetSum];
    }
}
