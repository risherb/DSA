class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        n--;

        for(int i = 0;i < 63;i++){
            if((ans & (1L << i)) == 0){
                if((n&1) == 1){
                    ans |= (1L << i);
                }
                n >>= 1;
            }
        }

        return ans;
    }
}