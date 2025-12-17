class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n=prices.length;
        long [][][] dp=new long[n][k+1][3];
        for(long [][] arr:dp){
            for(long [] a:arr){
                Arrays.fill(a,-1);
            }
        }
        return helper(prices,0,k,0,dp);
    }
    // 1 -> normal transaction
    // 2 -> short selling transaction
    // 0 -> skip 
    public static long helper(int [] prices,int idx,int k,int type,long [][][] dp){
        if(idx>=prices.length){
            if(type==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[idx][k][type]!=-1){
            return dp[idx][k][type];
        }
        long buy=0,dont_buy=0;
        dont_buy=helper(prices,idx+1,k,type,dp);
        if(k>0){
            if(type==1){
                buy=prices[idx]+helper(prices,idx+1,k-1,0,dp);
            }
            else if(type==2){
                buy=helper(prices,idx+1,k-1,0,dp)-prices[idx];
            }
            else{
                long a=helper(prices,idx+1,k,1,dp)-prices[idx];
                long b=prices[idx]+helper(prices,idx+1,k,2,dp);
                buy=Math.max(a,b);
            }
        }
        return dp[idx][k][type]=Math.max(buy,dont_buy);
    }
}