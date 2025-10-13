class Solution {
    static int n;
    public boolean predictTheWinner(int[] nums) {
        n=nums.length;
        int [][] dp=new int[n][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        int diff=helper(nums,0,n-1,dp);
        return diff>=0;
    }
    public static int helper(int [] nums,int i,int j,int [][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[i];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=nums[i]-helper(nums,i+1,j,dp);
        int right=nums[j]-helper(nums,i,j-1,dp);

        return dp[i][j]=Math.max(left,right);
    }
}