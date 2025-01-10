class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        if (words2.length == 0) {
            return Arrays.asList(words1);
        }

        HashMap<Character, Integer> maxFreq = new HashMap<>();
        for (String word : words2) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (char c : word.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                maxFreq.put(entry.getKey(), Math.max(maxFreq.getOrDefault(entry.getKey(), 0), entry.getValue()));
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words1) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (char c : word.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : maxFreq.entrySet()) {
                if (entry.getValue() > freq.getOrDefault(entry.getKey(), 0)) {
                    flag = false;
                    break;
            }
            }
            if (flag) {
                result.add(word);
            }
        }
        return result;
    }
}