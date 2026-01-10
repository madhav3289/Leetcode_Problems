class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2){
            return 2;
        }
        int maxLen=2;
        int [][] dp=new int[n][1002];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int diff=nums[i]-nums[j];
                maxLen=Math.max(maxLen,2+helper(nums,diff,i,dp));
            }
        }
        return maxLen;
    }
    public static int helper(int [] nums,int diff,int idx,int [][] dp){
        if(idx<0){
            return 0;
        }
        if(dp[idx][diff+501]!=-1){
            return dp[idx][diff+501];
        }
        int res=0;
        for(int i=idx-1;i>=0;i--){
            if(nums[i]-nums[idx]==diff){
                int val=1+helper(nums,diff,i,dp);
                res=Math.max(res,val);
            }
        }
        return dp[idx][diff+501]=res;
    }
}