/*162 - Find Peak Element
Difficulty : Medium
Topic : Binary Search, Arrays
Time : O(log(n)) average (can degrade due to end--)
Space : O(1) */

// Try to find a peak element (greater than neighbors).
// Uses a modified binary search with explicit neighbor checks.
class Solution {

    public int findPeakElement(int[] nums) {

        // Edge case: only one element → it is the peak
        if (nums.length == 1) {
            return 0;
        }

        // Edge case: two elements → return index of larger one
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        int start = 0;
        int end = nums.length - 1;

        // Binary search loop
        while (start < end) {

            int mid = start + (end - start) / 2; // avoids overflow

            // Check if mid itself is a peak (greater than both neighbors)
            if (mid > 0 && (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])) {
                end = mid;
                return end; // peak found

            // If mid is greater than left neighbor → increasing slope → move right
            } else if (mid > 0 && nums[mid] > nums[mid - 1]) {
                start = mid + 1;

            // Otherwise move left by shrinking end
            } else {
                end--;
            }
        }

        return end; // fallback → peak index
    }
}