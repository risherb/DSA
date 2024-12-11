public class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxValue = Arrays.stream(nums).max().getAsInt() + k * 2 + 2;
        int[] delta = new int[maxValue];

        for (int flower : nums) {
            delta[flower]++;
            if (flower + k * 2 + 1 < maxValue) {
                delta[flower + k * 2 + 1]--;
            }
        }

        int maxBeauty = 0;
        int runningSum = 0;

        for (int value : delta) {
            runningSum += value;
            maxBeauty = Math.max(maxBeauty, runningSum);
        }

        return maxBeauty;
    }
}
