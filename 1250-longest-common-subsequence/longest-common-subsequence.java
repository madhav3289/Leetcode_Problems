class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int [][] dp=new int[n][m];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(text1,text2,0,0,dp);
    }
    public static int helper(String s,String t,int i,int j,int [][] dp){
        if(i>=s.length() || j>=t.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int count=0;
        if(s.charAt(i)==t.charAt(j)){
            count=1+helper(s,t,i+1,j+1,dp);
        }
        int left=helper(s,t,i+1,j,dp);
        int right=helper(s,t,i,j+1,dp);

        return dp[i][j]=Math.max(count,Math.max(left,right));
    }
}