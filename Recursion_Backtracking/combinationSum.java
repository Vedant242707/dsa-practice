/*39 - Combination Sum
Difficulty : Medium
Topic : Backtracking, Recursion, Arrays
Time : O(2^target) approx (depends on combinations formed)
Space : O(target) recursion stack (excluding output) */

// Use backtracking to generate all combinations that sum to target.
// At each step, choose an element and reduce the target.
// We can reuse the same element multiple times → pass same index (i).
// If target becomes 0 → valid combination found.
// If target < 0 → invalid path, stop exploring.
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> outer = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), outer);

        return outer;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> internal, List<List<Integer>> outer) {

        if (target < 0) {
            return; // exceeded target → invalid path
        }

        if (target == 0) {
            outer.add(new ArrayList<>(internal)); // valid combination
            return;
        }

        // try all choices starting from 'start'
        for (int i = start; i < candidates.length; i++) {

            internal.add(candidates[i]); // choose current element

            // stay at same index (i) → element can be reused
            backtrack(candidates, target - candidates[i], i, internal, outer);

            internal.remove(internal.size() - 1); // backtrack (undo choice)
        }
    }
}