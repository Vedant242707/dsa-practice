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
        // List to store all valid board configurations
        List<List<String>> allboards = new ArrayList<>();

        // Create an n x n board initialized with '.' representing empty cells
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        // Start the recursive backtracking process from the first row (row 0)
        backtrack(board, allboards, 0);

        return allboards;
    }

    public void backtrack(char[][] board, List<List<String>> allboards, int row) {
        // Base Case: If we have successfully placed queens in all rows (row == n)
        if (row == board.length) {
            List<String> internal = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                // Convert each row (char array) into a String and add to the current solution
                internal.add(new String(board[j]));
            }
            allboards.add(internal);
            return;
        }

        // Iterate through each column in the current row to find a safe spot for the queen
        for (int col = 0; col < board.length; col++) {
            // Check if it is safe to place a queen at the current (row, col) position
            if (isSafe(row, col, board)) {
                // Action: Place the queen at board[row][col]
                board[row][col] = 'Q';
                
                // Recurse: Move to the next row to place the next queen
                backtrack(board, allboards, row + 1);
                
                // Backtrack: Remove the queen from the current position to explore other column possibilities
                board[row][col] = '.';
            }
        }
    }

    // Utility function to check if placing a queen at board[row][col] is safe from other queens
    public boolean isSafe(int row, int col, char[][] board) {
        // 1. Vertical Check: Check if any queen is present in the same column in previous rows
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 2. Upper Left Diagonal Check: Check for queens in the diagonal extending upwards and to the left
        int r = row;
        for (int c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // 3. Upper Right Diagonal Check: Check for queens in the diagonal extending upwards and to the right
        r = row;
        for (int c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // If no queens are found in the column or diagonals, the position is safe
        return true;
    }
}
