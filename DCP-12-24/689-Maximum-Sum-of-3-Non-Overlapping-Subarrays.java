class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        int bestLeft = 0;
        for (int i = k - 1; i < n; i++) {
            int sum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            if (i == k - 1 || sum > prefixSum[bestLeft + k] - prefixSum[bestLeft]) {
                bestLeft = i + 1 - k;
            }
            left[i] = bestLeft;
        }

        int bestRight = n - k;
        for (int i = n - k; i >= 0; i--) {
            int sum = prefixSum[i + k] - prefixSum[i];
            if (i == n - k || sum >= prefixSum[bestRight + k] - prefixSum[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }


        int maxSum = 0;
        int[] result = new int[3];
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int totalSum = (prefixSum[l + k] - prefixSum[l])
                         + (prefixSum[i + k] - prefixSum[i])
                         + (prefixSum[r + k] - prefixSum[r]);
            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }

        return result;
    }
}
