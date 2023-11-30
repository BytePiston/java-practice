package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knights {
    public static void main(String[] args) {
        int n=2;
        boolean[][] board = new boolean[n][n];
        solve(board, 0, 0, n);
    }

    private static void printBoard(boolean[][] board) {

    }

    private static void solve(boolean[][] board, int row, int col, int knight) {
        if(knight == 0){
            construct(board);
            System.out.println();
            return;
        }
        if(row == board.length-1 && col == board.length)
            return;
        if(col == board.length){
            solve(board, row+1, 0, knight);
            return;
        }

        if(isSafe(board, row, col)){
            board[row][col] = true;
            solve(board, row, col+1, knight-1);
            board[row][col] = false;
        }
        solve(board, row, col+1, knight);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //Check for top-left-row
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1])
                return false;
        }
        if(isValid(board, row-1, col-2)){
             if(board[row-1][col-2])
                 return false;
        }
        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1])
                return false;
        }
        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2])
                return false;
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void construct(boolean[][] board) {
        for(int i=0; i< board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<board.length; j++){
                if(board[i][j])
                    sb.append("K");
                else
                    sb.append(".");
            }
            System.out.println(sb);
        }
    }
}
