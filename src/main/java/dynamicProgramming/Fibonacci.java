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
     * Solution Approach 1 Using Single Iteration:
     * <p>
     * Time Complexity -> O(n)
     * Space Complexity -> O(1) Constant space since we are only storing 3 values.
     */
    public long fibonacciSingleIteration(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long prevPrev = 0;
        long prev = 1;
        long current = 0;
        for (int i = 2; i <= n; i++) {
            current = prevPrev + prev;
            prevPrev = prev;
            prev = current;
        }
        return current;
    }

    /**
     * @param n -> Any positive natural number for which we required Fibonacci number.
     * @return -> Returns the Fibonacci number of requested number.
     * <p>
     * Solution Approach 2: Using Normal Recursion:
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
     * Solution Approach 2: Using Memoization:
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

    /**
     * @param n-> Any positive natural number for which we required Fibonacci number.
     * @return -> Returns the Fibonacci number of requested number.
     * <p>
     * Solution Approach 3: Using Tabulation:
     * <p>
     * To Reduce the Time complexity from O(2^n) to O(n) we will use Tabulation Technique.
     * We will create array of size [n+1] and assign following value:
     * [0] = 0
     * [1] = 1
     * Now in a single iteration we will update the array stating from index i =0.
     * for each value of index i in the array it holds the fibonacci value of index i hence
     * at the last index of the array we will have our answer.
     * This reduces overall recursion calls for the numbers
     * which are previously computed hence reducing overall time complexity.
     * <p>
     * Time Complexity -> O(n)
     * Space Complexity -> O(n) i.e Size of the array.
     */
    public long tabulizedFibonacci(int n) {
        long[] tab = new long[n + 1];
        tab[1] = 1;
        for (int i = 0; i <= n; i++) {
            if (i + 1 <= n)
                tab[i + 1] += tab[i];
            if (i + 2 <= n)
                tab[i + 2] += tab[i];
        }
        return tab[n];
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
