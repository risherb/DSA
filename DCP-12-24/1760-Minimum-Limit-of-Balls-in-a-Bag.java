class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left=1;int right=0;
        for(int num:nums){
            right=Math.max(right,num);

        }
        while(left<right){
            int mid=left+(right-left)/2;
            int count=0;
            for(int num:nums){
                count+=(num-1)/mid;
                if(count>maxOperations)
                break;
            }
                if(count>maxOperations){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            
        }
            return left;
        
    }
}