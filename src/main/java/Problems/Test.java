package Problems;

import java.util.*;

public class Test {

    public static void main(String[] args) {
//        int[] testArray = {128, 429};
//        try {
//            int result = solution(testArray);
//            System.out.println("Longest fragment length: " + result);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }


        System.out.println(finMaxFragmentLength(new int[]{23, 333, 33, 30, 0, 505})); // Expected output: 4
        System.out.println(finMaxFragmentLength(new int[]{615, 88, 498, 99, 9}));     // Expected output: 2
        System.out.println(finMaxFragmentLength(new int[]{123, 456}));                // Expected output: 0
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        //start, end pointers will keep track of inner list in which new element would be added. if duplicate found then we will not not create duplicate subsets for such elements.
        int start = 0;
        int end = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i - 1] == nums[i]) {
                start = end + 1;
            }
            end = result.size() - 1;
            for (int j = start; j < result.size(); j++) {
                List<Integer> innerList = new ArrayList<>(result.get(j));
                innerList.add(nums[i]);
                result.add(innerList);
            }
        }
        return result;
    }

    public static int solution(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        if (A.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxLength = 0;
        int currentLength = 1;
        Set<Character> digits = new HashSet<>();

        for (int num : A) {
            Set<Character> numDigits = extractDigits(num);

            if (numDigits.size() > 2) {
                digits.clear();
                currentLength = 1;
            } else {
                digits.addAll(numDigits);

                if (digits.size() > 2) {
                    digits.clear();
                    currentLength = 1;
                } else {
                    ++currentLength;
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }

    /**
     * Extracts unique digits from an integer.
     *
     * @param num The integer to extract digits from.
     * @return A set of characters representing the unique digits.
     */
    private static Set<Character> extractDigits(int num) {
        Set<Character> digitSet = new HashSet<>();
        char[] digits = String.valueOf(num).toCharArray();
        for (char digit : digits) {
            digitSet.add(digit);
        }
        return digitSet;
    }


    private static int findMaxLength(int[] A) {
        int maxLength = 0;
        for (int i = 0; i < A.length; i++) {
            Set<Character> uniqueSet = new HashSet<>();
            int currentLength = 0;
            for (int j = i; j < A.length; j++) {
                uniqueSet.addAll(extractDigits(A[j]));
                if (uniqueSet.size() <= 2) {
                    currentLength = j - i + 1;
                    maxLength = Math.max(currentLength, maxLength);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }


    private static int finMaxFragmentLength(int[] A) {
        Map<Integer, Integer> digitCounts = new HashMap<>();
        int maxConsistentFragmentLength = 0;
        int currentConsistentFragmentLength = 0;
        for (int num : A) {
            digitCounts.clear();
            int lastDigit = -1;
            while (num > 0) {
                int digit = num % 10;
                if (lastDigit != -1 && lastDigit != digit) {
                    break;
                }
                lastDigit = digit;
                digitCounts.put(digit, digitCounts.getOrDefault(digit, 0) + 1);
                num /= 10;
            }
            if (digitCounts.size() == 1) {
                currentConsistentFragmentLength += digitCounts.keySet().iterator().next() + 1;
            } else {
                currentConsistentFragmentLength = 0;
            }
            maxConsistentFragmentLength = Math.max(maxConsistentFragmentLength, currentConsistentFragmentLength);
        }
        return maxConsistentFragmentLength;
    }

}
