/*
75-Sort Colors
Difficulty : Medium
Topic : Arrays, Pointers
Time : O(n)
Space : O(1)
*/class dutchflag {
    public void sortColors(int[] nums) {
        // 3-pointer approach:
        // 'zero' handles 0s at the start
        // 'end' handles 2s at the end
        // 'one' is the current element we are processing
        int zero = 0;
        int one = 0;
        int end = nums.length - 1;

        while(one <= end) {
            if(nums[one] == 0) {
                // Found a 0: swap it to the 'zero' position
                // Increment both because we know the swapped element at 'one' is processed
                swap(nums, zero, one);
                zero++;
                one++;
            } else if(nums[one] == 1) {
                // Found a 1: it's already in the middle, just move to next
                one++;
            } else {
                // Found a 2: swap it to the 'end' position
                // Decrement 'end', but DO NOT increment 'one' as we need to check the new value swapped from the end
                swap(nums, one, end);
                end--;
            }
        }
    }

    public void swap(int nums[], int one, int two) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }
}