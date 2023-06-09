package dynamicProgramming;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 * <p>
 * Say that you are a Traveler on a 2D grid. You begin in the top-left corner and your goal is to travel to the
 * bottom-right corner.
 * NOTE: You may only move down or right.
 * <p>
 * In how many ways can you travel to the goal on a grid with dimensions m*n?
 * <p>
 * Write a function 'gridTraveler(m,n)' that calculates this.
 * <p>
 * Example:
 * <p>
 * For following 2X3 matrix the output for gridTraveler(2,3) --> 3 ways to reach bottom-right corner.
 * _________________________
 * | Start |   -   |   -   |
 * -------------------------
 * |   -   |   -   |  End  |
 * -------------------------
 * <p>
 * Possible solutions are:
 * <p>
 * 1.  _________________________
 * | Start |   X   |   X   |     :   Right --> Right --> Down
 * -------------------------
 * |   -   |   -   |  End  |
 * -------------------------
 * <p>
 * 2.  _________________________
 * | Start |   X   |   -   |     :   Right --> Down --> Right
 * -------------------------
 * |   -   |   X   |  End  |
 * -------------------------
 * <p>
 * 3.  _________________________
 * | Start |   -   |   -   |     :   Down --> Right --> Right
 * -------------------------
 * |   X   |   X   |  End  |
 * -------------------------
 */

public class GridTraveler {

    /**
     * Solution Approach 1 Using Normal Recursion:
     * Divide the overall matrix into smaller matrix and try to see if it matches the below base condition:
     * <p>
     * If we go DOWN then decrease the row count since we now have a reduced matrix with 1 less row, and similarly when
     * go right decrease the column count.
     * <p>
     * Total ways will be computing both DOWN and RIGHT combinations till we reach base conditions and then add them back
     * along the way.
     * <p>
     * Base conditions: 1.  When row || column is 0 --> 0 moves since such matrix does not exist. i.e 0X5 || 8X0 || 0X0.
     * 2.  1X1 Matrix --> Only 1 move since no movement required.
     * <p>
     * Time Complexity: O(2^m+n)
     * Space Complexity: O(m+n) i.e Height of the Tree.
     */
    public long gridTraveler(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

    /**
     * Solution Approach 2 Using Memoization:
     * <p>
     * Everytime we come across any pair of rows and columns for computation
     * before calling the recursion function we will check if the pair was previously computed and
     * can be found in the HashMap if so then we return the computed total number of moves required from the HashMap.
     * This reduces overall recursion calls for the previously computed pairs hence reducing overall time complexity.
     * <p>
     * NOTE:  gridTraveler(m,n) = gridTraveler(n,m)
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m+n) i.e Height of the Tree.
     */
    public long memoizedGridTraveler(int m, int n, Map<String, Long> memo) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if (memo.containsKey(m + "," + n))
            return memo.get(m + "," + n);
        else if (memo.containsKey(n + "," + m))
            return memo.get(n + "," + m);
        memo.put(m + "," + n,
                memoizedGridTraveler(m - 1, n, memo) + memoizedGridTraveler(m, n - 1, memo));
        return memo.get(m + "," + n);
    }

    public long computeTimeGridTraveler(int m, int n) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        gridTraveler(m, n);
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }

    public long computeTimeMemoizedGridTraveler(int m, int n) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        memoizedGridTraveler(m, n, new HashMap<>());
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }
}
