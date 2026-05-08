import java.util.*;

/*
51-N-Queens
Difficulty : Hard
Topic : Recursion, Backtracking
Time : O(N!)
Space : O(N^2)
*/
class nqueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allboards = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, allboards, 0);

        return allboards;
    }

    public void backtrack(char[][] board, List<List<String>> allboards, int row) {
        if (row == board.length) {
            List<String> internal = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                internal.add(new String(board[j]));
            }
            allboards.add(internal);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(board, allboards, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, char[][] board) {
        // Horizontal check (not needed since we move row by row)
        
        // Vertical check
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper Left Diagonal
        int r = row;
        for (int c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Upper Right Diagonal
        r = row;
        for (int c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
