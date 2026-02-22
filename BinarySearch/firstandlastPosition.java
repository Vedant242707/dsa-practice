/*34 - Find First and Last Position of an Element in a Sorted Array
Difficulty : Medium
Topic : Binary Search, Arrays
Time : O(log(n))
Space : O(1) */

// Single method handles both first & last search — boolean avoids writing two separate methods.
// firstposition=true  → after match, search left  (narrows down to first occurrence)
// firstposition=false → after match, search right (narrows down to last occurrence)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = findindex(nums, target, true);
        ans[1] = findindex(nums, target, false);

        return ans;
    }

    int findindex(int[] arr, int target, boolean firstposition) {

        int ans = -1;
        int start = 0; 
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if (target < arr[mid]) {
                end = mid-1;
            } else if (target > arr[mid]) {
                start = mid+1;
            } else if (target == arr[mid]) {
                ans = mid;

                if (firstposition) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}