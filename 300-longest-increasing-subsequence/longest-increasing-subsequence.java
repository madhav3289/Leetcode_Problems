class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][] dp=new int[n][n+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public static int helper(int [] nums,int idx,int prev,int [][] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int take=0;
        int skip=0;
        if(prev==-1 || nums[prev]<nums[idx]){
            take=1+helper(nums,idx+1,idx,dp);
        }
        skip=helper(nums,idx+1,prev,dp);
        return dp[idx][prev+1]=Math.max(take,skip);
    }
}