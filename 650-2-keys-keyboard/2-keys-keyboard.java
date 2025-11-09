class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        int [][] dp=new int[n+1][n+1];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return helper(n,1,1,dp);
    }
    public static int helper(int n,int curLen,int lastLen,int [][] dp){
        if(curLen==n){
            return 1;
        }
        if(curLen>n){
            return 999999;
        }
        if(dp[curLen][lastLen]!=-1){
            return dp[curLen][lastLen];
        }
        int copyPaste=2+helper(n,curLen*2,curLen,dp);
        int paste=1+helper(n,curLen+lastLen,lastLen,dp);
        return dp[curLen][lastLen]=Math.min(copyPaste,paste);
    }
}