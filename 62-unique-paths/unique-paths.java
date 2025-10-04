class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(m,n,0,0,dp);
    }
    public static int helper(int m,int n,int row,int col,int [][] dp){
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(row>=m || col>=n){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=0;
        count+=helper(m,n,row,col+1,dp);
        count+=helper(m,n,row+1,col,dp);
        return dp[row][col]=count;
    }
}