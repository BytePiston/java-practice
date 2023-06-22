package dynamicProgramming;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Find the Fibonacci of the given number.
 * <p>
 * Fibonacci series of N natual number --> 1, 1, 2, 3, 5, 8, ...
 */
public class Fibonacci {

    /**
     * @param n -> Any positive natural number for which we required Fibonacci number.
     * @return -> Returns the Fibonacci number of requested number.
     * <p>
     * Solution Approach 1 Using Normal Recursion:
     * fib(n) = fib(n-1) + fib(n-2)
     * <p>
     * Time Complexity -> O(2^n)
     * Space Complexity -> O(n) i.e Height of the Tree.
     */
    public long fibonacci(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Negative numbers are not allowed!!!");
        if (n <= 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * To Reduce the Time complexity from O(2^n) to O(n) we will use Memoization Technique to store the fibonacci number of
     * common elements from both fib(n-1) and fib(n-2) tree to reduce computation for already visited natural number in the sequence.
     *
     * @param n-> Any positive natural number for which we required Fibonacci number.
     * @return -> Returns the Fibonacci number of requested number.
     * <p>
     * Solution Approach 2 Using Memoization:
     * Everytime we come across any number for computation before calling the recursion function
     * we will check if the number was previously computed and can be found in the HashMap
     * if so then we return the fibonacci number from the HashMap.
     * This reduces overall recursion calls for the numbers
     * which are previously computed hence reducing overall time complexity.
     * <p>
     * Time Complexity -> O(n)
     * Space Complexity -> O(n) i.e Height of the Tree.
     */
    public long memoizedFibonacci(int n, HashMap<Integer, Long> memo) {
        if (n <= 0)
            throw new IllegalArgumentException("Negative numbers are not allowed!!!");
        if (memo.containsKey(n))
            return memo.get(n);
        if (n <= 2)
            return 1;
        memo.put(n, memoizedFibonacci(n - 1, memo) + memoizedFibonacci(n - 2, memo));
        return memo.get(n);
    }

    public long computeTimeFibonacci(int n) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        fibonacci(n);
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }

    public long computeTimeMemoizedFibonacci(int n) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        memoizedFibonacci(n, new HashMap<>());
        return Calendar.getInstance().getTimeInMillis() - startTime;
    }
}
