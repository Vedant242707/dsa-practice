/*46 - Permutations
Difficulty : Medium
Topic : Backtracking, Recursion, Arrays
Time : O(n * n!)
Space : O(n) recursion stack (excluding output) */

// Generate all permutations of the array.
// At each step, try every element that is NOT already used in the current permutation.
// When the current list size equals nums.length → one permutation is complete.
// Use backtracking: pick → explore → unpick.
class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> outer = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), outer);

        return outer;
    }

    private void backtrack(int[] nums, List<Integer> internal, List<List<Integer>> outer) {

        // if permutation is complete
        if (internal.size() == nums.length) {
            outer.add(new ArrayList<>(internal));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // skip elements already used in current permutation
            if (!internal.contains(nums[i])) {

                internal.add(nums[i]); // choose element

                backtrack(nums, internal, outer); // explore

                internal.remove(internal.size() - 1); // backtrack (undo choice)
            }
        }
    }
}