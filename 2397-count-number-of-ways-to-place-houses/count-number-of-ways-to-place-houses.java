class Solution {
    long mod=(long)1e9+7;
    Long dp[];
    public long solve(int i,int n){
        if(i>=n){
            return 1;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        long take=solve(i+2,n);
        long notake=solve(i+1,n);
        return dp[i]=(take+notake)%mod;
    }
    public int countHousePlacements(int n) {
        dp=new Long[n];
        long ways=solve(0,n);
        return (int)((ways*ways)%mod);
    }
}