class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int [][] dp=new int[n][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(s,0,n-1,dp);
    }
    public static int helper(String s,int lo,int hi,int [][] dp){
        if(lo>hi){
            return 0;
        }
        if(lo==hi){
            return 1;
        }
        if(dp[lo][hi]!=-1){
            return dp[lo][hi];
        }
        if(s.charAt(lo)==s.charAt(hi)){
            return 2+helper(s, lo+1, hi-1,dp);
        }
        int max1=0;
        int max2=0;
        if(s.charAt(lo)!=s.charAt(hi)){
            max1=helper(s, lo+1, hi,dp);
            max2=helper(s, lo, hi-1,dp);
        }
        return dp[lo][hi]=Math.max(max1,max2);
    }
}