/*367 - Valid Perfect Square
Difficulty : Easy
Topic : Binary Search, Math
Time : O(log(n))
Space : O(1) */

// Use binary search to check if there exists an integer whose square equals num.
// Instead of comparing mid*mid with num (which may overflow),
// compare mid with num/mid.
// If mid == num/mid and num % mid == 0 → perfect square found.
class Solution {
    public boolean isPerfectSquare(int num) {

        if (num == 0 || num == 1) {
            return true; // 0 and 1 are perfect squares
        }

        int start = 1;
        int end = num;

        while (start <= end) {

            int mid = start + (end - start) / 2; // avoids overflow

            if (mid == num / mid && num % mid == 0) {
                return true;      // exact square root exists

            } else if (mid > num / mid) {
                end = mid - 1;    // mid² too large → search left

            } else {
                start = mid + 1;  // mid² too small → search right
            }
        }

        return false; // no integer square root found
    }
}