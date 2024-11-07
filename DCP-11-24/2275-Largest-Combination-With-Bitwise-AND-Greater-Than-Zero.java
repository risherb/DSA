class Solution {
    public int largestCombination(int[] candidates) {
        int maxSubsetSize = 0;

        for (int bitPosition = 0; bitPosition < 24; bitPosition++) {
            List<Integer> subset = new ArrayList<>();

            for (int num : candidates) {
                if (((num >> bitPosition) & 1) == 1) {
                    subset.add(num);
                }
            }

            if (!subset.isEmpty()) {
                int cumulativeAnd = subset.get(0);
                int subsetSize = 1;

                for (int i = 1; i < subset.size(); i++) {
                    cumulativeAnd &= subset.get(i);

                    if (((cumulativeAnd >> bitPosition) & 1) == 1) {
                        subsetSize++;
                    } else {
                        break;
                    }
                }

                maxSubsetSize = Math.max(maxSubsetSize, subsetSize);
            }
        }

        return maxSubsetSize;    
    }
}