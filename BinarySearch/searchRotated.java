/*33 - Search in Rotated Sorted Array
Difficulty : Medium
Topic : Binary Search, Arrays
Time : O(log(n))
Space : O(1) */

// The array is a rotated sorted array.
// Step 1: Find the pivot/peak index where rotation happens.
// Step 2: Decide which sorted half may contain the target.
// Step 3: Perform a normal binary search in that half.
class Solution {

    public int search(int[] nums, int target) {

        int peak = findpeak(nums); // index where rotation occurs
        int ans = -1;

        // If array is not rotated (peak is last element)
        if (peak == nums.length - 1) {
            ans = findelement(nums, target, 0, nums.length - 1);
        }

        // Check if target lies in left sorted portion
        if (target >= nums[0] && target <= nums[peak]) {
            ans = findelement(nums, target, 0, peak);

        } else { // otherwise search in right portion
            ans = findelement(nums, target, peak + 1, nums.length - 1);
        }

        return ans;
    }

    // Find the pivot index where arr[i] > arr[i+1]
    int findpeak(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2; // avoids overflow

            // Handle case where mid falls in rotated section
            if (mid > 0 && arr[mid] <= arr[start]) {
                mid = start;
            }

            // If current element greater than next → pivot found
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                end = mid;

            } else {
                start = mid + 1; // move right
            }
        }

        return start; // pivot index
    }

    // Standard binary search in a given range
    int findelement(int[] arr, int target, int start, int end) {

        int start1 = start;
        int end1 = end;

        while (start1 <= end1) {

            int mid = start1 + (end1 - start1) / 2;

            if (arr[mid] < target) {
                start1 = mid + 1; // search right

            } else if (arr[mid] > target) {
                end1 = mid - 1; // search left

            } else {
                return mid; // target found
            }
        }

        return -1; // target not present
    }
}