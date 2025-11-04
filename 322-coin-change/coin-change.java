class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp=new int[amount+1][coins.length];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        int min=helper(coins,amount,0,dp);
        return (min==999999)?-1:min;
    }
    public static int helper(int [] coins,int amount,int idx,int [][] dp){
        if(amount<0 || idx>=coins.length){
            return 999999;
        }
        if(amount==0){
            return 0;
        }
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }
        int count=Integer.MAX_VALUE;
        if(amount-coins[idx]>=0){
            int inc=1+helper(coins,amount-coins[idx],idx,dp);
            count=Math.min(count,inc);
        }
        int exc=helper(coins,amount,idx+1,dp);
        count=Math.min(count,exc);
        return dp[amount][idx]=count;
    }
}