class Solution {
    Set<Character> owls;
    public int[] vowelStrings(String[] words, int[][] queries) {
        owls = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u'));
        int[] prec = new int[words.length+1];

        for(int i = 0; i<words.length; i++){
            prec[i+1]=prec[i];
            if(isOwWord(words[i])){
                prec[i+1]++;
            }
        }

        int[] ans = new int[queries.length];
        for(int i=0; i<ans.length; i++){
            int q[] = queries[i];
            ans[i] = prec[q[1]+1]-prec[q[0]];
        }
        return ans;
    }

    private boolean isOwWord(String w){
        return owls.contains(w.charAt(0)) && owls.contains(w.charAt(w.length()-1));
    }
}