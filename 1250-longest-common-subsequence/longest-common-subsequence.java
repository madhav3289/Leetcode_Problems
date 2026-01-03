class Solution {
    static int n;
    static int m;
    public int longestCommonSubsequence(String text1, String text2) {
        n=text1.length();
        m=text2.length();
        int [][] dp=new int[n][m];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(text1,text2,0,0,dp);
    }
    public static int helper(String text1,String text2,int idx1,int idx2,int [][] dp){
        if(idx1>=n || idx2>=m){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        int a=0,b=0;
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            return 1+helper(text1,text2,idx1+1,idx2+1,dp);
        }
        else{
            a=helper(text1,text2,idx1+1,idx2,dp);
            b=helper(text1,text2,idx1,idx2+1,dp);
        }
        return dp[idx1][idx2]=Math.max(a,b);
    }
}