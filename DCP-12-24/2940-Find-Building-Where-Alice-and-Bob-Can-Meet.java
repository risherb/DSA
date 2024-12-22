class Solution {
    public int[] leftmostBuildingQueries(int[] buildingHeights, int[][] buildingQueries) {
        int totalBuildings = buildingHeights.length;
        int[] answers = new int[buildingQueries.length];
        Arrays.fill(answers, -1);
        List<List<int[]>> queryList = new ArrayList<>();
        
        for(int i = 0; i < totalBuildings; i++) {
            queryList.add(new ArrayList<>());
        }     
        for(int queryIdx = 0; queryIdx < buildingQueries.length; queryIdx++) {
            int start = buildingQueries[queryIdx][0];
            int end = buildingQueries[queryIdx][1];
            
            if(start > end) {
                int swap = start;
                start = end;
                end = swap;
            }
            
            if(start == end || buildingHeights[start] < buildingHeights[end]) {
                answers[queryIdx] = end;
            }else {
                queryList.get(end).add(new int[]{buildingHeights[start], queryIdx});
            }
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int currentIndex = 0; currentIndex < totalBuildings; currentIndex++) {
            int currentHeight = buildingHeights[currentIndex];
            for(int[] pendingQuery : queryList.get(currentIndex)) {
                heap.add(pendingQuery);
            }
            while(!heap.isEmpty() && heap.peek()[0] < currentHeight) {
                int[] topQuery = heap.poll();
                int queryIndex = topQuery[1];
                answers[queryIndex] = currentIndex;
            }
        }

        return answers;
    }
}