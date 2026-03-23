/*154 - Find Minimum in Rotated Sorted Array II
Difficulty : Hard
Topic : Binary Search, Arrays
Time : O(log(n)) average, O(n) worst (due to duplicates)
Space : O(1) */

// Use binary search to find the minimum element in a rotated array with duplicates.
// Compare mid with end:
// - nums[mid] < nums[end] → minimum lies in left half (including mid)
// - nums[mid] > nums[end] → minimum lies in right half
// - nums[mid] == nums[end] → cannot decide → shrink search space (end--)
// Loop ends when start == end → minimum element.
class Solution {

    public int findMin(int[] nums) {

        // Edge case: single element OR already sorted (no rotation)
        if (nums.length == 1 ||
            (nums[0] < nums[1] && nums[0] < nums[nums.length - 1])) {
            return nums[0];
        }

        return findpeak(nums); // returns minimum element
    }

    private int findpeak(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2; // avoids overflow

            if (nums[mid] < nums[end]) {
                end = mid;          // minimum in left half

            } else if (nums[mid] > nums[end]) {
                start = mid + 1;    // minimum in right half

            } else {
                end--;              // duplicates → shrink search space
            }
        }

        return nums[start]; // start == end → minimum element
    }
}