public class WordSearch {
    public static boolean findNext(char[][] board, int row, int col, String word, int idx) {
        if(idx == word.length()) {
            return true;
        }

        if(row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] != word.charAt(idx)  || board[row][col] == '.') {
            return false;
        }

        char ch = board[row][col];
        board[row][col] = '.';

        boolean top = findNext(board, row-1, col, word, idx+1);
        boolean right = findNext(board, row, col+1, word, idx+1);
        boolean bottom = findNext(board, row+1, col, word, idx+1);
        boolean left = findNext(board, row, col-1, word, idx+1);

        board[row][col] = ch;

        if(top || right || bottom || left) {
            return true;
        }

        return false;
    }
    
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        int idx = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == word.charAt(idx)) {
                    if(findNext(board, i, j, word, idx)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};String word = "ABCCED";

        System.out.println(exist(board, word));
    }
}
