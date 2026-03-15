/*78 - Subsets
Difficulty : Medium
Topic : Backtracking, Bit Manipulation, Iterative
Time : O(n * 2^n)
Space : O(n * 2^n) */

// Build subsets iteratively.
// Start with the empty subset [].
// For every number in nums:
//   - Take all existing subsets.
//   - Add the current number to each of them to create new subsets.
//   - Append these new subsets to the list.
// This doubles the number of subsets for every element.
class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>()); // start with empty subset

        for (int i : nums) {

            int n = outer.size(); // current number of subsets

            // iterate over existing subsets
            for (int j = 0; j < n; j++) {

                // copy existing subset
                List<Integer> internal = new ArrayList<>(outer.get(j));

                internal.add(i); // add current element to it

                outer.add(internal); // add new subset to result
            }
        }

        return outer; // contains all 2^n subsets
    }
}