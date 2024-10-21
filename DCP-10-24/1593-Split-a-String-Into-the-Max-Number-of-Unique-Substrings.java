class Solution {
    public int maxUniqueSplit(String s) {
          return backtrack(s, 0, new HashSet<>());
    }
    
    private int backtrack(String s, int start, HashSet<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        int maxCount = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substr = s.substring(start, end);
            if (!seen.contains(substr)) {
                seen.add(substr);
                maxCount = Math.max(maxCount, 1 + backtrack(s, end, seen));
                seen.remove(substr);
            }
        }
        return maxCount;
        
    }
}