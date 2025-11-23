class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int [][] dp=new int[n][3];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return helper(nums,0,0,dp);
    }
    public static int helper(int [] nums,int idx,int rem,int [][] dp){
        if(idx>=nums.length){
            return (rem==0)?0:Integer.MIN_VALUE;
        }
        if(dp[idx][rem]!=-1){
            return dp[idx][rem];
        }
        int inc=nums[idx]+helper(nums,idx+1,(rem+nums[idx])%3,dp);
        int exc=helper(nums,idx+1,rem,dp);
        return dp[idx][rem]=Math.max(inc,exc);
    }
}