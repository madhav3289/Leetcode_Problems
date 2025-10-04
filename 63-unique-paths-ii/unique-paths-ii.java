class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[m-1][n-1]==1){
            return 0;
        }
        int [][] dp=new int[m][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(grid,0,0,dp);
    }
    public static int helper(int [][] grid,int row,int col,int [][] dp){
        if(row==grid.length-1 && col==grid[0].length-1){
            return 1;
        }
        if(row>=grid.length || col>=grid[0].length){
            return 0;
        }
        if(grid[row][col]==1){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=0;
        count+=helper(grid,row,col+1,dp);
        count+=helper(grid,row+1,col,dp);
        return dp[row][col]=count;
    }
}