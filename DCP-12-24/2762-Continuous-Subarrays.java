import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;
        int left = 0;

        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }

            minDeque.addLast(right);
            maxDeque.addLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
