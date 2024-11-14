class Solution {
    public boolean func(int n, int[] quantities, int m) {
        for(int q : quantities) {
            n -= (q+m-1)/m;
            if(n < 0) return false;
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 100000;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(func(n, quantities, mid)) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}