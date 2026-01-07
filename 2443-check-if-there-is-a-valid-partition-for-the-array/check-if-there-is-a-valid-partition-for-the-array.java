class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        // if length is less than 2 means we can't partition into valid subarray
        if(n<2){
            return false;
        }
        Boolean [] dp=new Boolean[n];
        return helper(nums,0,n,dp);
    }
    public static boolean helper(int [] nums,int idx,int n,Boolean [] dp){
        // if we reach last index means ther has been valid partition so return true
        if(idx>=n){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        boolean isValid=false;
        // exactly two equal elements..
        if(idx<n-1 && nums[idx]==nums[idx+1]){
            isValid|=helper(nums,idx+2,n,dp);
        }
        // exactly three equal elements..
        if(idx<n-2 && nums[idx]==nums[idx+1] && nums[idx+1]==nums[idx+2]){
            isValid|=helper(nums,idx+3,n,dp);
        }
        // exactly three consecutive increasing elements..
        if(idx<n-2 && nums[idx]+1==nums[idx+1] && nums[idx+1]+1==nums[idx+2]){
            isValid|=helper(nums,idx+3,n,dp);
        }
        return dp[idx]=isValid;
    }
}