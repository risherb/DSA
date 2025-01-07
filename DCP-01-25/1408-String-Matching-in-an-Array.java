class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                }
            }
        }
        return new ArrayList<>(result);
    
}
}