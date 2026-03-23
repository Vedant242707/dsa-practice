/*47 - Permutations II
Difficulty : Medium
Topic : Backtracking, Recursion, Arrays
Time : O(n * n!) 
Space : O(n) recursion stack (excluding output) */

// Generate all unique permutations.
// Sort the array so duplicates are adjacent.
// Use a boolean[] to track which indices are already used.
// This ensures we only pick the first unused duplicate at a given level.
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> outer = new ArrayList<>();

        Arrays.sort(nums); // required for duplicate handling

        boolean[] check = new boolean[nums.length]; // tracks used elements

        backtrack(nums, check, new ArrayList<>(), outer);

        return outer;
    }

    private void backtrack(int[] nums, boolean[] check, List<Integer> internal, List<List<Integer>> outer) {

        // if permutation is complete
        if (internal.size() == nums.length) {
            outer.add(new ArrayList<>(internal));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // skip if already used OR duplicate not allowed at this position
            if (check[i] || (i > 0 && nums[i] == nums[i - 1] && !check[i - 1])) {
                continue;
            }

            check[i] = true;              // mark as used
            internal.add(nums[i]);       // choose element

            backtrack(nums, check, internal, outer); // explore

            internal.remove(internal.size() - 1); // backtrack (undo choice)
            check[i] = false;            // unmark
        }
    }
}