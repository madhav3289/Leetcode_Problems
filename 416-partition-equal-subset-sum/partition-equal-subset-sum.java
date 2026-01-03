class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        Boolean [][] dp=new Boolean[nums.length][sum+1];
        return helper(nums,sum,0,0,dp);
    }
    public static boolean helper(int [] nums,int sum,int idx,int cSum,Boolean [][] dp){
        if(idx>=nums.length){
            return false;
        }
        if(dp[idx][cSum]!=null){
            return dp[idx][cSum];
        }
        if(cSum==sum/2){
            return true;
        }
        // take the current elemnt 
        boolean take=helper(nums,sum,idx+1,cSum+nums[idx],dp);
        // skip the current index
        boolean skip=helper(nums,sum,idx+1,cSum,dp);
        return dp[idx][cSum]=(take||skip);
    }
}