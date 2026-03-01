/*852 - Peak Index in a Mountain Array
Difficulty : Medium
Topic : Binary Search, Arrays
Time : O(log(n))
Space : O(1) */

// Binary search on mountain array.
// If mid element > next element → we are on descending side (peak is at mid or left).
// If mid element < next element → we are on ascending side (peak is to the right).
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0; 
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2; // avoids integer overflow

            if (arr[mid] > arr[mid + 1]) {
                end = mid;        // move left including mid (possible peak)
            } else {
                start = mid + 1;  // move right (peak ahead)
            } 
        }

        return end; // start == end → peak index
    }
}