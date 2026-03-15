/*35 - Search Insert Position
Difficulty : Easy
Topic : Binary Search, Arrays
Time : O(log(n))
Space : O(1) */

// Binary search on sorted array.
// If target found → return its index.
// If target not found → loop ends when start crosses end.
// 'start' will point to the correct position where target should be inserted.
class Solution {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // avoids integer overflow

            if (target == nums[mid]) {
                return mid;          // target found

            } else if (nums[mid] > target) {
                end = mid - 1;       // search left half

            } else {
                start = mid + 1;     // search right half
            }
        }

        return start; // insertion index when target not present
    }
}