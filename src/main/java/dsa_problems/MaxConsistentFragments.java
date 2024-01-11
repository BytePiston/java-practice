package dsa_problems;

import java.util.HashSet;
import java.util.Set;

public class MaxConsistentFragments {

    private boolean canUseTwoDigits(int num) {
        String numStr = Integer.toString(num);
        return numStr.chars().distinct().count() <= 2;
    }

    private int findMaxLength(int[] A) {
        int maxLength = 0;

        for (int i = 0; i < A.length; i++) {
            Set<Character> uniqueDigits = new HashSet<>();
            int currentLength = 0;

            for (int j = i; j < A.length; j++) {
                String numStr = Integer.toString(A[j]);
                for (char ch : numStr.toCharArray()) {
                    uniqueDigits.add(ch);
                }

                if (uniqueDigits.size() <= 2) {
                    currentLength = j - i + 1;
                    maxLength = Math.max(maxLength, currentLength);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        MaxConsistentFragments solution = new MaxConsistentFragments();
        System.out.println(solution.findMaxLength(new int[]{23, 333, 33, 30, 0, 505})); // Expected output: 4
        System.out.println(solution.findMaxLength(new int[]{615, 88, 498, 99, 9}));     // Expected output: 2
        System.out.println(solution.findMaxLength(new int[]{123, 456}));                // Expected output: 0
    }
}
