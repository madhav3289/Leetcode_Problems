class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        int [][] dp=new int[n+1][m+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }

        return LCS(n,m,text1,text2,0,0,dp);
    }

    public static int LCS(int n,int m,String text1,String text2,int i,int j,int [][] dp){
        if(i>=n || j>=m){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+LCS(n,m,text1,text2,i+1,j+1,dp);
        }
        return dp[i][j]=Math.max(LCS(n,m,text1,text2,i+1,j,dp),LCS(n,m,text1,text2,i,j+1,dp));
    }
}