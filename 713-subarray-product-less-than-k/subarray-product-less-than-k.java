class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1;
        int lo=0,hi=0;
        int count=0;
        while(hi<nums.length){
            prod*=nums[hi];
            while(prod>=k && lo<=hi){
                prod/=nums[lo];
                lo++;
            }
            count+=(hi-lo+1);
            hi++;
        }
        return count;
    }
}