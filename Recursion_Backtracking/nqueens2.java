import java.util.*;

/*
52-N-Queens II
Difficulty : Hard
Topic : Backtracking
Time : O(N!)
Space : O(N^2)
*/
class nqueens2 {
    private int count;

    public int totalNQueens(int n) {
        // Use a boolean board where 'true' represents a queen placement
        boolean[][] board = new boolean[n][n];
        count = 0;

        // Start the backtracking process from the first row (row 0)
        backtrack(board, 0);

        return count;
    }

    public void backtrack(boolean[][] board, int row) {
        // Base Case: If we have successfully placed queens in all rows, increment the counter
        if (row == board.length) {
            count++;
            return;
        }

        // Iterate through each column in the current row
        for (int col = 0; col < board.length; col++) {
            // Check if placing a queen at board[row][col] is safe
            if (isSafe(board, row, col)) {
                // Action: Place the queen
                board[row][col] = true;
                
                // Recurse: Try placing queens in the next row
                backtrack(board, row + 1);
                
                // Backtrack: Remove the queen to explore other configurations
                board[row][col] = false;
            }
        }
    }

    // Helper function to check if a queen can be safely placed at board[row][col]
    public boolean isSafe(boolean[][] board, int row, int col) {
        // 1. Vertical Check: Ensure no queen is in the same column in any previous rows
        for (int i = 0; i < row; i++) {
            if (board[i][col] == true) {
                return false;
            }
        }

        // 2. Upper Left Diagonal Check
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == true) {
                return false;
            }
        }

        // 3. Upper Right Diagonal Check
        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == true) {
                return false;
            }
        }

        // Position is safe if no threats are found in the column or diagonals
        return true;
    }
}
