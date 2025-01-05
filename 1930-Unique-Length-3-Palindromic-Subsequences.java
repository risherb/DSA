class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        HashSet<Character> intermediateSet = new HashSet<>();
        
        // Add all unique characters from the string to the set
        for (char ch : s.toCharArray()) {
            uniqueChars.add(ch);
        }

        int count = 0;
        // Iterate through each unique character
        for (char ch : uniqueChars) {
            int firstIndex = s.indexOf(ch);
            int lastIndex = s.lastIndexOf(ch);
            
            // If the character appears only once, skip it
            if (firstIndex == lastIndex) continue;

            // Collect all unique characters between the first and last occurrence
            for (int i = firstIndex + 1; i < lastIndex; i++) {
                intermediateSet.add(s.charAt(i));
            }

            // Add the size of the intermediate set to the count
            count += intermediateSet.size();
            intermediateSet.clear();
        }

        return count;
    }
}