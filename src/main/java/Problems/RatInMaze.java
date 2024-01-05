package Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider a rat placed at (0, 0) in a square matrix of order N * N.
 * It has to reach the destination at (N - 1, N - 1).
 * Find all possible paths that the rat can take to reach from source to destination.
 * The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
 * Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it
 * while value 1 at a cell in the matrix represents that rat can be travel through it.
 * */
public class RatInMaze {

    public static void main(String[] args) {
        int sizeOfMaze = 4;
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        //Result: ["DDRDRR", "DRDDRR"],
        System.out.println(findPath(maze, sizeOfMaze));
    }

    public static List<String> findPath(int[][] m, int n) {
        // Your code here
        //Lax order of movement D-L-R-U.
        boolean[][] visited = new boolean[n][n];
        List<String> result = new ArrayList<>();
        findPathHelper(m, result, visited, 0,0, "");
        return result;
    }

    static void findPathHelper(int[][] maze, List<String> result, boolean[][] visited, int row, int col, String potentialAnswer){

        if(row==visited.length-1 && col==visited[0].length-1 && maze[row][col] == 1){
            result.add(potentialAnswer);
            return;
        }

        //Check if we can move Down, Left, Right, Up, if so move and mark it as visited and Add it to string for recurrsion call.
        if(!isSafe(row, col, visited, maze)){
            return;
        }
        int[][] directions = new int[][]{{1,0}, {0, -1}, {0, 1}, {-1, 0}};
        String[] directionChar = new String[]{"D", "L", "R", "U"};

        for(int i=0; i<directionChar.length; i++){
            visited[row][col] = true;
            findPathHelper(maze, result, visited, row+directions[i][0], col+directions[i][1], potentialAnswer+directionChar[i]);
            visited[row][col] = false;
        }
    }

    static boolean isSafe(int row, int col, boolean[][] visited, int[][] maze){
        return row>=0 && row<visited.length && col>=0 && col<visited[0].length && !visited[row][col] && maze[row][col] == 1;
    }
}
