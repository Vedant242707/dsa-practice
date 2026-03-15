/*81 - Search in Rotated Sorted Array II
Difficulty : Medium
Topic : Binary Search, Arrays
Time : O(log(n)) average
Space : O(1) */

// The array is a rotated sorted array.
// Step 1: Find the pivot (rotation point) where arr[i] > arr[i+1].
// Step 2: Decide which sorted half may contain the target.
// Step 3: Perform standard binary search in that half.
// Instead of returning index, this version returns true/false if target exists.
class Solution {

    public boolean search(int[] nums, int target) {

        int peak = findpeak(nums); // index where rotation occurs
        boolean ans = false;

        // If array is not rotated, search the entire array
        if (peak == nums[nums.length - 1]) {
            ans = findelement(nums, target, 0, nums.length - 1);
        }

        // If target lies in the left sorted portion
        if (target >= nums[0] && target <= nums[peak]) {
            ans = findelement(nums, target, 0, peak);

        } else { // otherwise search in the right portion
            ans = findelement(nums, target, peak + 1, nums.length - 1);
        }

        return ans;
    }

    // Finds the pivot index where arr[i] > arr[i+1]
    int findpeak(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2; // avoids overflow

            // Handle case where mid falls in rotated section
            if (mid > 0 && arr[mid] <= arr[start]) {
                mid = start;
            }

            // If current element is greater than next → pivot found
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                end = mid;

            } else {
                start = mid + 1; // move right
            }
        }

        return start; // pivot index
    }

    // Standard binary search in a given range
    boolean findelement(int[] arr, int target, int start, int end) {

        int start1 = start;
        int end1 = end;

        while (start1 <= end1) {

            int mid = start1 + (end1 - start1) / 2;

            if (arr[mid] < target) {
                start1 = mid + 1; // search right

            } else if (arr[mid] > target) {
                end1 = mid - 1; // search left

            } else {
                return true; // target found
            }
        }

        return false; // target not present
    }
}