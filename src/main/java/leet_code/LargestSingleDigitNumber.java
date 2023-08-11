package leet_code;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the maximum among all one-digit integer.
 * <p>
 * For example, given A = [-6, -91, 1011, -100, 84, -22,0,1,473], the function should return 1.
 * <p>
 * N is an integer within the range [1..1,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
public class LargestSingleDigitNumber {

    public static void main(String[] args) {

    }

    public static int maxSingleDigit(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            if (num >= -9 && num <= 9) {
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
