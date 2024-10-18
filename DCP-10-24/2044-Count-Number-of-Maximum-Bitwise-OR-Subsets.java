class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0, count = 0;
        for (int num : nums) maxOr |= num;
        return countSubsets(nums, 0, 0, maxOr);
    }

    private int countSubsets(int[] nums, int index, int currentOr, int maxOr) {
        if (index == nums.length) return currentOr == maxOr ? 1 : 0;
        return countSubsets(nums, index + 1, currentOr | nums[index], maxOr) + 
               countSubsets(nums, index + 1, currentOr, maxOr);
    }
}
