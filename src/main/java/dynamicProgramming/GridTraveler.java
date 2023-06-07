package dynamicProgramming;

/*
 * Problem Statement:
 *
 * Say that you are a Traveler on a 2D grid. You begin in the top-left corner and your goal is to travel to the
 * bottom-right corner.
 * NOTE: You may only move down or right.
 *
 * In how many ways can you travel to the goal on a grid with dimensions m*n?
 *
 * Write a function 'gridTraveler(m,n)' that calculates this.
 *
 * Example:
 *
 * For following 2X3 matrix the output for gridTraveler(2,3) --> 3 ways to reach bottom-right corner.
 * _________________________
 * | Start |   -   |   -   |
 * -------------------------
 * |   -   |   -   |  End  |
 * -------------------------
 *
 * Possible solutions are:
 *
 * 1.  _________________________
 *     | Start |   X   |   X   |     :   Right --> Right --> Down
 *     -------------------------
 *     |   -   |   -   |  End  |
 *     -------------------------
 *
 * 2.  _________________________
 *     | Start |   X   |   -   |     :   Right --> Down --> Right
 *     -------------------------
 *     |   -   |   X   |  End  |
 *     -------------------------
 *
 * 3.  _________________________
 *     | Start |   -   |   -   |     :   Down --> Right --> Right
 *     -------------------------
 *     |   X   |   X   |  End  |
 *     -------------------------
 *
 *
 * Solution Approach 1 Using Normal Recursion:
 *
 * Divide the overall matrix into smaller matrix and try to see if it matches the below base condition:
 *
 * If we go DOWN then decrease the row count since we now have a reduced matrix with 1 less row, and similarly when
 * go right decrease the column count.
 *
 * Total ways will be computing both DOWN and RIGHT combinations till we reach base conditions and then add them back
 *  along the way.
 *
 * Base conditions: 1.  When row || column is 0 --> 0 moves since such matrix does not exist. i.e 0X5 || 8X0 || 0X0.
 *                  2.  1X1 Matrix --> Only 1 move since no movement required.
 *
 * Time Complexity: O(2^m+n)
 * Space Complexity: O(m+n) i.e Height of the Tree.
 *
 * Solution Approach 2 Using Memoization:
 *
 * Everytime we come across any pair of rows and columns for computation
 * before calling the recursion function we will check if the pair was previously computed and
 * can be found in the HashMap if so then we return the computed total number of moves required from the HashMap.
 * This reduces overall recursion calls for the previously computed pairs hence reducing overall time complexity.
 *
 * NOTE:  gridTraveler(m,n) = gridTraveler(n,m)
 *
 * Time Complexity: O(m*n)
 * Space Complexity: O(m+n) i.e Height of the Tree.
 */

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    public long gridTraveler(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

    public long memoizationGridTraveler(int m, int n, Map<String, Long> memo) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        if (memo.containsKey(m + "," + n))
            return memo.get(m + "," + n);
        else if (memo.containsKey(n + "," + m))
            return memo.get(n + "," + m);
        memo.put(m + "," + n, memoizationGridTraveler(m - 1, n, memo) + memoizationGridTraveler(m, n - 1, memo));
        return memo.get(m + "," + n);
    }

    public long computeTimeGridTraveler(int m, int n) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        gridTraveler(m, n);
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }

    public long computeTimeMemoizationGridTraveler(int m, int n) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        memoizationGridTraveler(m, n, new HashMap<>());
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }
}
