class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
       int i = 0, j = 0; 
        while(i < str1.length() && j < str2.length()){
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(j);

            if(char1 == char2 || (char1 == 'z' && char2 == 'a') ||
            (char1 + 1 == char2 )  ) {
                i ++ ;
                j++ ;
            }

            else {
               i ++ ;
            }
        }
         return  j == str2.length() ;
    }
}