class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int [][] dp=new int[n][m];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,0,0,dp);
    }
    public static int helper(String s1,String s2,int i,int j,int [][] dp){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a=0,b=0;
        if(s1.charAt(i)==s2.charAt(j)){
            return helper(s1,s2,i+1,j+1,dp);
        }
        else{
            a=1+helper(s1,s2,i+1,j,dp);
            b=1+helper(s1,s2,i,j+1,dp);
        }
        return dp[i][j]=Math.min(a,b);
    }
}