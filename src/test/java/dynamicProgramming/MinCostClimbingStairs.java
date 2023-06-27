package dynamicProgramming;

/**
 * Problem Statement:
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * <p>
 * Example 2:
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 */
public class MinCostClimbingStairs {
    /*
     * Approach 1: Using Iterative logic.
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] tab = new int[cost.length + 1];
        tab[0] = cost[0];
        tab[1] = cost[1];
        for (int i = 2; i <= tab.length - 1; i++) {
            if (i == cost.length)
                tab[i] = Math.min(tab[i - 1], tab[i - 2]);
            else
                tab[i] = Math.min(cost[i] + tab[i - 1], cost[i] + tab[i - 2]);
        }
        return tab[cost.length];

    }

    /*
     * Approach 2: Using Recursive logic.
     */
    public static int minCostClimbingStairsRecursion(int[] cost) {
        return Math.min(minCostClimbingStairsRecursion(cost, 0, 0), minCostClimbingStairsRecursion(cost, 1, 0));
    }

    public static int minCostClimbingStairsRecursion(int[] cost, int index, int minCost) {
        if (index >= cost.length)
            return minCost;
        minCost += cost[index];
        return Math.min(minCostClimbingStairsRecursion(cost, index + 1, minCost), minCostClimbingStairsRecursion(cost, index + 2, minCost));
    }

    public int getMaximumGenerated(int n) {
        int[] tab = new int[n+1];
        int max = 0;
        tab[0]=0;
        tab[1]=1;
        for(int i=2; i<tab.length; i++){
            if(i%2==0)
                tab[i]=tab[i/2];
            else
                tab[i]= tab[(int)Math.floor(i/2)]+tab[(int)Math.floor(i/2)+1];
            max = Math.max(tab[i], max);
        }
        return max;
    }
}
