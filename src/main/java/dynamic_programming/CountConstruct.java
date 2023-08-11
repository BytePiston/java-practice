package dynamic_programming;

import java.util.Map;

/**
 * Write a function 'countConstruct(target, wordBank)' that accepts a target string and array of strings.
 * <p>
 * The function should return a int indicating whether it is  possible to construct 'target' string by concatenating elements
 * from the 'wordBank' array and if so then in how many ways we can construct the 'target' string else return 0.
 * <p>
 * You may reuse elements of 'wordBank' as many times as needed.
 * <p>
 * Example:
 * countConstruct(abcdef, [ab, abc, cd, def, abcd]) --> return 1 i.e.: abc + def -> abcdef.
 * countConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) --> return 0.
 */
public class CountConstruct {
    /**
     * @param target   --> Target string which we want to construct.
     * @param wordBank --> Array of string which we can use to construct target string.
     * @return --> Return a number of ways whether it is  possible to construct 'target' string.
     * <p>
     * Approach 1: We will slice the target string recursively only if the element from the wordBank starts
     * with the incoming string in recursion call.
     * <p>
     * Ex: In countConstruct(abcdef, [ab, abc, cd, def, abcd]) we will not use cd to slice abcdef since cd is in middle of the word
     * and does not start with it. Hence, we will only consider element ab, abc, abcd in the 1st recursive call and so on until we find empty string.
     * Once empty string is found we will return 1 else 0;
     * <p>
     * m --> target.length;
     * n --> wordBank.length;
     * Time Complexity: O((n^m)*m) -> since we will also do string substring which will multiplied m to overall time complexity.
     * Space Complexity: O(m^2) -> Height of the tree. Since in the recursion only one path will be stored at a time also
     * additional m will be multiplied for substring operation.
     */
    public int countConstruct(String target, String[] wordBank) {
        if (target.isEmpty())
            return 1;
        int totalCount = 0;
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                int ans = countConstruct(target.substring(word.length()), wordBank);
                totalCount += ans;
            }
        }
        return totalCount;
    }

    /**
     * @param target   --> Target string which we want to construct.
     * @param wordBank --> Array of string which we can use to construct target string.
     * @return --> Return a int indicating number of ways whether it is  possible to construct 'target' string.
     * <p>
     * Approach 2: We will add the totalCount to memo object.
     * <p>
     * m --> target.length;
     * n --> wordBank.length;
     * Time Complexity: O((n^m)*m) -> since we will also do string substring which will multiplied m to overall time complexity.
     * Space Complexity: O(m^2) -> Height of the tree. Since in the recursion only one path will be stored at a time also
     * additional m will be multiplied for substring operation.
     */
    public int memoizedCountConstruct(String target, String[] wordBank, Map<String, Integer> memo) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target.isEmpty())
            return 1;
        int totalCount = 0;
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                int ans = memoizedCountConstruct(target.substring(word.length()), wordBank, memo);
                totalCount += ans;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }
}
