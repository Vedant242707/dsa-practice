/*40 - Combination Sum II
Difficulty : Medium
Topic : Backtracking, Recursion, Arrays
Time : O(2^n) (pruned by sorting & duplicate skipping)
Space : O(n) recursion stack (excluding output) */

// Generate all unique combinations that sum to target.
// Each element can be used ONLY once → move to i+1.
// Sort the array to group duplicates together.
// Skip duplicates using: if (i > start && nums[i] == nums[i-1]) continue;
// If target becomes 0 → valid combination.
// If target < 0 → stop exploring current path.
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> outer = new ArrayList<>();

        Arrays.sort(candidates); // required for duplicate handling

        backtrack(candidates, target, 0, new ArrayList<>(), outer);

        return outer;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> internal, List<List<Integer>> outer) {

        if (target < 0) {
            return; // exceeded target → invalid path
        }

        if (target == 0) {
            outer.add(new ArrayList<>(internal)); // valid combination found
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            internal.add(candidates[i]); // choose current element

            // move to next index → element cannot be reused
            backtrack(candidates, target - candidates[i], i + 1, internal, outer);

            internal.remove(internal.size() - 1); // backtrack (undo choice)
        }
    }
}