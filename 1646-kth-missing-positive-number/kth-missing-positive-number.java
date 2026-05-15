class Solution {
    public int findKthPositive(int[] nums, int k) {
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int rem=nums[mid]-(mid+1);
            if(rem<k){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return lo+k;
    }
}