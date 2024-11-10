class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int l = 1, h = nums.length;
        while(l <= h){
            int m = l + (h - l) / 2;
            if(hasSpeacialSubArray(nums, m, k))    h = m - 1;
            else    l = m + 1;
        }
        return h == nums.length ? -1 : h + 1;
    }
    private boolean hasSpeacialSubArray(int nums[], int size, int k){
        int bitCnt[] = new int[32], n = nums.length;
        for(int i = 0; i < n; i++){
            int curr_OR = get_OR_and_update_bit_cnt(bitCnt, nums[i], 1);
            if(curr_OR >= k)    return true;
            if(i >= size - 1)   get_OR_and_update_bit_cnt(bitCnt, nums[i - size + 1], -1);
        }
        return false;
    }
    private int get_OR_and_update_bit_cnt(int bitCnt[], int num, int updateVal){
        int curr_OR = 0;
        for(int i = 0; i < 32; i++){
            if((num & (1 << i)) != 0)  bitCnt[i] += updateVal;
            if(updateVal != -1)        curr_OR += (bitCnt[i] > 0) ? (1 << i) : 0;
        }
        return curr_OR;
    }
}