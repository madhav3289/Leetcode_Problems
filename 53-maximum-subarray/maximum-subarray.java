class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums,0,0,Integer.MIN_VALUE);
    }
    public static int helper(int [] nums,int idx,int sum,int max){
        if(idx==nums.length){
            return max;
        }
        sum=Math.max(sum+nums[idx],nums[idx]);
        max=Math.max(max,sum);
        return helper(nums,idx+1,sum,max);
    }
}