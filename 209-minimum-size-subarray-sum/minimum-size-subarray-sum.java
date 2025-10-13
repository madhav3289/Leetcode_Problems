class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int lo=0,hi=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        while(hi<nums.length){
            sum+=nums[hi];
            while(sum>=target){
                min=Math.min(min,hi-lo+1);
                sum-=nums[lo];                
                lo++;
            }
            hi++;
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }
}