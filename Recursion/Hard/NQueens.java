import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static boolean isSafe(char[][] board, int row, int col, int n) {
        // Checking for col
        for(int i=0; i<n; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Checking for upper left digonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // Checking for upper right diagonal
        for(int i=row, j=col; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
    public static void solveNQueenHelper(List<List<String>> result, char[][] board, int row, int n) {
        // base case 
        if(row == n) {
            constructSolution(board, result, n);
            return;
        }

        for(int col=0; col<n; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solveNQueenHelper(result, board, row+1, n);
                board[row][col] = '.';
            }
        }
    }

    public static void constructSolution(char board[][], List<List<String>> result, int n) {
        List<String> sol = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            sol.add(new String(board[i]));
        }
        
        result.add(sol);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        // creating the board first
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }

        int row = 0;
        solveNQueenHelper(result, board, row, n);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
