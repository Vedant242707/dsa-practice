/*90 - Subsets II
Difficulty : Medium
Topic : Backtracking, Arrays, Subset Pattern (Iterative)
Time : O(n * 2^n)
Space : O(n * 2^n) */

// Generate all subsets while avoiding duplicates.
// Sort the array so duplicate numbers are adjacent.
// When a duplicate element appears, only extend the subsets
// that were created in the previous step. This prevents generating
// duplicate subsets and removes the need for expensive contains() checks.
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums); // group duplicate elements together

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>()); // start with empty subset

        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {

            start = 0;

            // if current number is duplicate, only extend the subsets
            // generated in the previous iteration
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1; // last index of existing subsets

            int n = outer.size();

            for (int j = start; j < n; j++) {

                // copy existing subset
                List<Integer> internal = new ArrayList<>(outer.get(j));

                internal.add(nums[i]); // include current element

                outer.add(internal); // add new subset
            }
        }

        return outer; // contains all unique subsets
    }
}