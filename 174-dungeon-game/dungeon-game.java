class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int [][] dp=new int[grid.length][grid[0].length];
        for(int [] arr:dp){
            Arrays.fill(arr,-9999999);
        }
        return helper(grid,0,0,dp);
    }
    public static int helper(int [][] grid,int i,int j,int [][] dp){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            if(grid[i][j]>0){
                return 1;
            }
            return Math.abs(grid[i][j])+1;
        }
        if(dp[i][j]!=-9999999){
            return dp[i][j];
        }
        // move right
        int right=helper(grid,i,j+1,dp);
        // move down
        int down=helper(grid,i+1,j,dp);
        
        int min=Math.min(right,down)-grid[i][j];

        return dp[i][j]=(min>0)?min:1;
    }
}