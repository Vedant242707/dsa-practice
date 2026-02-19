/*744 - Find the Smallest Letter Strictly Greater than the Target
Difficulty : Easy
Topic : Binary Search, Arrays
Time : O(log(n))
Space : O(1) */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        // We’re searching for the first letter strictly greater than target
        while (start <= end) {
            int mid = start + (end - start) / 2;  // Safe mid calculation

            if (letters[mid] > target) {
                // This could be our answer,
                // but maybe there’s a smaller valid one on the left
                end = mid - 1;
            } else {
                // letters[mid] <= target → not useful, move right
                start = mid + 1;
            }
        }

        // If we went past the last index,
        // modulo brings us back to index 0 (circular case)
        return letters[start % letters.length];
    }
}
