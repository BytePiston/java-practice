package dsa_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement:
 * <p>
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * Example 1:
 * Input: numRows = 5
 * Output:
 * [[1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]]
 * <p>
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            long prev = 1;
            for (int j = 0; j <= i; j++) {
                row.add((int) prev);
                prev = prev * (i - j) / (j + 1);
            }
            ans.add(row);
        }
        return ans;
    }

    public List<List<Integer>> generateRecursion(int numRows, List<List<Integer>> triangles) {
        if (numRows == 1) {
            triangles.add(List.of(1));
            return triangles;
        }
        generateRecursion(numRows - 1, triangles);
        List<Integer> newRow = new ArrayList<>();
        List<Integer> previousRow = triangles.get(numRows - 2);
        newRow.add(1);
        for (int i = 1; i < numRows - 1; i++)
            newRow.add(i, previousRow.get(i - 1) + previousRow.get(i));
        newRow.add(1);
        triangles.add(newRow);
        return triangles;
    }
}
