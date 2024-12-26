class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, nums.length - 1);
    }

    private int helper(int[] nums, int target, int index) {
        if (index < 0) {
            return target == 0 ? 1 : 0;
        }
        int add = helper(nums, target - nums[index], index - 1);
        int subtract = helper(nums, target + nums[index], index - 1);
        return add + subtract;
    }
}
