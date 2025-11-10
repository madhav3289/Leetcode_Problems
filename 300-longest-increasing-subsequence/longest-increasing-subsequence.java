class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][] dp=new int[n][n+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public static int helper(int [] nums,int idx,int lastIdx,int [][] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][lastIdx+1]!=-1){
            return dp[idx][lastIdx+1];
        }
        int take=0;
        if(lastIdx==-1 || nums[idx]>nums[lastIdx]){
            take=1+helper(nums,idx+1,idx,dp);
        }
        int skip=helper(nums,idx+1,lastIdx,dp);
        return dp[idx][lastIdx+1]=Math.max(take,skip);
    }
}