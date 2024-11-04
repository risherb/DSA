class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        
        while (!word.isEmpty()) {
            char currentChar = word.charAt(0);
            int count = 0;
            
            while (count < 9 && count < word.length() && word.charAt(count) == currentChar) {
                count++;
            }
            
            comp.append(count).append(currentChar);
            word = word.substring(count);
        }
        
        return comp.toString();
    }
}
