package leet_code;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the size of the largest possible subset of A such that bitwise operation AND  of all its elements is  greater than 0.
 * <p>
 * For example-1, given A = [13,7,2,8,3], the function should return 3.
 * we can pick subset 13, 7 and 3. AND of these elements is positive and it is the largest possible subset of numbers that fulfils the criteria.
 * <p>
 * 1101 (13) AND 0111 (7) AND 0011(3) =0001(1)
 * <p>
 * For example-2, given A = [1,2,4,8], the function should return 1.
 * The AND bitwise operation of each pair from the array is equal to 0.
 * <p>
 * For example-3, given A = [16,16], the function should return 2.
 * Since The AND bitwise operation of both the number is equal to 16.
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */

/**
 * Solution:
 * <p>
 * In this updated solution, we use a bitmask to represent each possible subset of the input array. We iterate over all possible bitmasks from 1 to (1 << n) - 1, where n is the length of the array.
 * <p>
 * For each bitmask, we iterate over the elements of the array. If the i-th bit of the bitmask is set (1), we perform a bitwise AND operation with the corresponding element in the array and increment the subset size.
 * <p>
 * If the resulting bitwise AND is greater than 0, we update the maxSubsetSize if the current subset size is larger.
 * <p>
 * Finally, we return maxSubsetSize, which represents the size of the largest subset where the bitwise AND of all its elements is greater than 0.
 * <p>
 * Now, if you execute solution([13, 7, 2, 8, 3]), it should correctly return 3, which is the size of the largest subset where the bitwise AND of all its elements is greater than 0.
 */
public class MaxSubsetAndBitwise {

    public static void main(String[] args) {

    }

    public static int maxSubsetAndBitwise(int[] A) {
        int max = 0;
        for (int i = 1; i < (1 << A.length); i++) {
            int bitwiseAND = -1;
            int subsetSize = 0;

            for (int j = 0; j < A.length; j++) {
                if ((i & (1 << j)) != 0) {
                    bitwiseAND &= A[j];
                    subsetSize++;
                }
            }

            if (bitwiseAND > 0) {
                max = Math.max(max, subsetSize);
            }
        }

        return max;
    }
}
