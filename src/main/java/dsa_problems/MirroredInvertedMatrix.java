package dsa_problems;

/**
 * Given a squared matrix k that only contains 0's and 1's, mirror it and then invert it.
 * Return the final matrix.
 * Mirroring a matrix is done by reversing every row: [ 1, 0, 0] row becomes [0, 0, 1]
 * Inverting a matrix is done by replacing 1's with 0's and 0's with 1's : [0, 1, 1] row becomes [1,0,0] after inverting it.
 * Example:
 * Input: K = [[1, 1,0], [1,0,1], [0,0,0]]
 * Output: [ [1,0,0], [0,1,0], [1,1,1]]
 */
public class MirroredInvertedMatrix {
    public static int[][] mirrorAndInvert(int[][] matrix) {
        int n = matrix.length;
        int[][] mirroredMatrix = new int[n][n];

        // Mirroring the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mirroredMatrix[i][j] = matrix[i][n - j - 1];
            }
        }

        // Inverting the matrix
        int[][] invertedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                invertedMatrix[i][j] = mirroredMatrix[i][j] == 0 ? 1 : 0;
            }
        }

        return invertedMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] result = mirrorAndInvert(matrix);

        // Printing the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
