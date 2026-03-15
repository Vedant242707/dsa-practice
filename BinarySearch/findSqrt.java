/*69 - Sqrt(x)
Difficulty : Easy
Topic : Binary Search, Math
Time : O(log(n))
Space : O(1) */

// Binary search to find the integer square root.
// Compare mid with x/mid instead of mid*mid to avoid overflow.
// If mid > x/mid → mid² is too large → move left.
// If mid < x/mid → mid² is too small → move right.
// If equal → exact square root found.
// When loop ends, 'end' holds the floor value of √x.
class Solution {
    public int mySqrt(int x) {

        if (x < 2) {
            return x; // sqrt(0) = 0, sqrt(1) = 1
        }

        int start = 1;
        int end = x / 2; // sqrt(x) cannot be greater than x/2 for x ≥ 2

        while (start <= end) {

            int mid = start + (end - start) / 2; // avoids overflow

            if (mid > x / mid) {
                end = mid - 1;    // mid² too large → search left

            } else if (mid < x / mid) {
                start = mid + 1;  // mid² too small → search right

            } else {
                return mid;       // exact square root found
            }
        }

        return end; // floor value of √x
    }
}