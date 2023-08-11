package leet_code;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement: Spinoff of Fibonacci Sequence.
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Constraints:
 * 1 <= n <= 45
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    int[] moves = {1, 2};

    /**
     * Approach 3: Using Tabulation.
     */
    public int memoizedClimbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return solve(n, moves, memo);
    }

    public int solve(int n, int[] moves, int[] memo) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (memo[n] >= 0)
            return memo[n];
        int ans = 0;
        for (int move : moves)
            ans += solve(n - move, moves, memo);
        memo[n] = ans;
        return ans;
    }

    /**
     * Approach 2: Treat this as a spinoff of Fibonacci Series.
     */
    private int climbStairsUsingFib(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, climbStairsUsingFib(n - 1, memo) + climbStairsUsingFib(n - 2, memo));
        return memo.get(n);
    }

    public int climbStairsUsingFib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairsUsingFib(n, memo);
    }

    /**
     * Approach 3: Using Tabulation.
     */
    public int tabulizedClimbStairs(int n) {
        int[] tab = new int[n+1];
        tab[0] = 1;
        for(int i=0; i<n; i++)
            for(int move: moves)
                if(i+move<=n)
                    tab[i+move]+=tab[i];
        return tab[n];
    }
}
