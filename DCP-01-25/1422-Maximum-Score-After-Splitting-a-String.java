class Solution {
    public int maxScore(String s) {
        int totalone = 0, one = 0,zero = 0,score=-1;
        for(char ch:s.toCharArray()) if(ch =='1') totalone++;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0') zero++;
            else one++;
            score = Math.max(score,zero+(totalone-one));
        }
        return score;
        
    }
}