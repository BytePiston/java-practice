package dynamicProgramming;

/**
 * Problem Statement:
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        char[] subStringArray = s.toCharArray();
        char[] targetArray = t.toCharArray();
        for (int i = 0, j = 0; i < targetArray.length; i++) {
            if (targetArray[i] == subStringArray[j])
                j++;
            if (j == subStringArray.length)
                return true;
        }
        return false;
    }
}
