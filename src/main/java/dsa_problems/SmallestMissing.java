package dsa_problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function:
 * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestMissing {

    public int smallestMissing(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }
        int missing = 1;
        while (set.contains(missing)) {
            missing++;
        }
        return missing;
    }
}
