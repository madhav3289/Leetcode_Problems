class Solution {
    static int mod=1_000_000_007;
    static int n;
    static int m;
    public int numberOfPaths(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        int [][][] memo=new int[n][m][k];
        for(int [][] a:memo){
            for(int [] aa:a){
                Arrays.fill(aa,-1);
            } 
        }
        return helper(grid,0,0,k,0,memo);
    }
    public static int helper(int [][] grid,int row,int col,int k,int cSum,int [][][] memo){
        if(row>=n || col>=m){
            return 0;
        }
        cSum=(cSum+grid[row][col])%k;
        if(row==n-1 && col==m-1){
            if(cSum%k==0){
                return 1;
            }
            return 0;
        }
        if(memo[row][col][cSum]!=-1){
            return memo[row][col][cSum];
        }
        int count=0;
        count+=helper(grid,row,col+1,k,cSum,memo);
        count+=helper(grid,row+1,col,k,cSum,memo);
        return memo[row][col][cSum]=(count%mod);
    }
}