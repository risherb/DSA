import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // Sort by arrival time
        int[][] events = new int[n][3]; // [arrival, leave, friend index]
        for (int i = 0; i < n; i++) {
            events[i] = new int[] {times[i][0], times[i][1], i};
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);  // Sort by arrival time

        // Priority Queue to store available chairs (min-heap)
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i); // Initially, all chairs are available
        }

        // Priority Queue to store friends leaving (min-heap sorted by leave time)
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            int arrival = events[i][0];
            int leaving = events[i][1];
            int friendIdx = events[i][2];

            // Free up chairs as friends leave
            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.offer(leavingQueue.poll()[1]); // Add the chair back
            }

            // Assign the smallest available chair
            int assignedChair = availableChairs.poll();

            // If this is the target friend, return their chair number
            if (friendIdx == targetFriend) {
                return assignedChair;
            }

            // Add this friend's leaving time and their chair to the leavingQueue
            leavingQueue.offer(new int[] {leaving, assignedChair});
        }

        return -1;  // This should never be reached
    }
}
