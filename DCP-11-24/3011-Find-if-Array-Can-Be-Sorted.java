class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int prevSegmentMax = Integer.MIN_VALUE;
        int currSegmentMax = nums[0];
        int currSegmentMin = nums[0];
        int setBitCount = Integer.bitCount(nums[0]);
        int i = 1; 
        while (i < n) {
            while (i < n && Integer.bitCount(nums[i]) == setBitCount) {
                currSegmentMax = Math.max(currSegmentMax, nums[i]);
                currSegmentMin = Math.min(currSegmentMin, nums[i]);
                i++;
            }
            if (prevSegmentMax > currSegmentMin) {
                return false;
            } else if (i < n) {
                prevSegmentMax = currSegmentMax;
                currSegmentMax = nums[i];
                currSegmentMin = nums[i];
                setBitCount = Integer.bitCount(nums[i]);
            }
        }
        return true;
    }
}