package dynamic_programming;

import java.util.Map;

/**
 * Write a function 'canConstruct(target, wordBank)' that accepts a target string and array of strings.
 * <p>
 * The function should return a boolean indicating whether it is  possible to construct 'target' string by concatenating elements
 * from the 'wordBank' array.
 * <p>
 * You may reuse elements of 'wordBank' as many times as needed.
 * <p>
 * Example:
 * canConstruct(abcdef, [ab, abc, cd, def, abcd]) --> return True i.e.: abc + def -> abcdef.
 * canConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) --> return False.
 */

public class CanConstruct {

    /**
     * @param target   --> Target string which we want to construct.
     * @param wordBank --> Array of string which we can use to construct target string.
     * @return --> Return a boolean indicating whether it is  possible to construct 'target' string.
     * <p>
     * Approach 1: We will slice the target string recursively only if the element from the wordBank starts
     * with the incoming string in recursion call.
     * <p>
     * Ex: In canConstruct(abcdef, [ab, abc, cd, def, abcd]) we will not use cd to slice abcdef since cd is in middle of the word
     * and does not start with it. Hence, we will only consider element ab, abc, abcd in the 1st recursive call and so on until we find empty string.
     * Once empty string is found we will return True else False;
     * <p>
     * m --> target.length;
     * n --> wordBank.length;
     * Time Complexity: O((n^m)*m) -> since we will also do string substring which will multiplied m to overall time complexity.
     * Space Complexity: O(m^2) -> Height of the tree. Since in the recursion only one path will be stored at a time also
     * additional m will be multiplied for substring operation.
     */
    public boolean canConstruct(String target, String[] wordBank) {
        if (target.isEmpty())
            return true;
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, wordBank))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param target   --> Target string which we want to construct.
     * @param wordBank --> Array of string which we can use to construct target string.
     * @return --> Return a boolean indicating whether it is  possible to construct 'target' string.
     * <p>
     * Approach 2: We will follow approach 1 but for every subString of targetSting
     * the result we will store in hashMap and return value if found in the map.
     * <p>
     * m --> target.length;
     * n --> wordBank.length;
     * Time Complexity: O(n*(m^2)) -> since we will only have to go through half if the tree due to memoization.
     * Space Complexity: O(m^2) -> Height of the tree. Since in the recursion only one path will be stored at a time also
     * additional m will be multiplied for substring operation.
     */
    public boolean memoizedCanConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target.isEmpty())
            return true;
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (memoizedCanConstruct(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }
}
