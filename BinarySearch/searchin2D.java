/*240 - Search a 2D Matrix II
Difficulty : Medium
Topic : Matrix, Binary Search (Search Space Reduction)
Time : O(m + n)
Space : O(1) */

// Start from the top-right corner of the matrix.
// If current element == target → found.
// If current element < target → move down (larger values).
// If current element > target → move left (smaller values).
// This works because rows are sorted left→right and columns top→bottom.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int r = 0;                         // start at first row
        int c = matrix[0].length - 1;      // start at last column (top-right)

        while (r < matrix.length && c >= 0) {

            if (matrix[r][c] == target) {
                return true;               // target found

            } else if (matrix[r][c] < target) {
                r++;                       // move down to larger values

            } else {
                c--;                       // move left to smaller values
            }
        }

        return false; // target not present in matrix
    }
}