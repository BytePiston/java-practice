import java.util.*;

public class Mifare {
    public static void main(String[] args) {

    int[] inputArray = {0x01, 0x01, -1, -1, -1, 0x09, 0x00, 0x00, 0x00, -1, -1, 0x01, 0x00, 0x00, 0x00, -1}; // -1 represents NULL

    // Increment the counter at the 5th index
    inputArray[5]++;

    boolean foundSolution = findSolution(inputArray, new HashSet<>(), 0);

        if (foundSolution) {
        // Print the valid solution
        for (int value : inputArray) {
            System.out.print(String.format("%02X", value) + " ");
        }
    } else {
        System.out.println("No valid solution found.");
    }
}

    static boolean findSolution(int[] inputArray, Set<Integer> usedValues, int index) {
        if (index == inputArray.length) {
            // Check if the XOR condition is met
            int xorResult = 0;
            for (int i = 0; i < inputArray.length; i++) {
                xorResult ^= inputArray[i];
            }
            return xorResult == 0;
        }

        if (inputArray[index] == -1) {
            // Try all possible values (0-255) for the current position
            for (int value = 0; value <= 255; value++) {
                if (!usedValues.contains(value)) {
                    inputArray[index] = value;
                    usedValues.add(value);

                    // Check if a solution can be found with unique hex values
                    boolean solutionWithUniqueHex = findSolution(inputArray, usedValues, index + 1);
                    if (solutionWithUniqueHex) {
                        return true; // Found a solution with unique hex values
                    }

                    // Backtrack
                    inputArray[index] = -1;
                    usedValues.remove(value);
                }
            }
        } else {
            // If the position is not empty, proceed to the next index
            return findSolution(inputArray, usedValues, index + 1);
        }

        // If no solution found with unique hex values, allow one duplicate hex value
        if (usedValues.size() < inputArray.length - 1) {
            for (int value = 0; value <= 255; value++) {
                if (!usedValues.contains(value)) {
                    inputArray[index] = value;
                    usedValues.add(value);

                    // Continue searching with duplicate hex value
                    boolean solutionWithDuplicateHex = findSolution(inputArray, usedValues, index + 1);
                    if (solutionWithDuplicateHex) {
                        return true; // Found a solution with one duplicate hex value
                    }

                    // Backtrack
                    inputArray[index] = -1;
                    usedValues.remove(value);
                }
            }
        }

        return false;
    }
}

