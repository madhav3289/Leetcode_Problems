class Solution {
    static int n;
    static int m;
    public int getMaximumGold(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean [][] visited=new boolean[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    max=Math.max(max,helper(grid,visited,i,j));
                }
            }
        }
        return max;
    }
    public static int helper(int [][] grid,boolean [][] visited,int row,int col){
        if(row<0 || col<0 || row>=n || col>=m){
            return 0;
        }
        if(grid[row][col]==0 || visited[row][col]){
            return 0;
        }
        visited[row][col]=true;
        int up=helper(grid,visited,row-1,col);
        int left=helper(grid,visited,row,col-1);
        int down=helper(grid,visited,row+1,col);
        int right=helper(grid,visited,row,col+1);
        visited[row][col]=false;

        return Math.max(Math.max(up,down),Math.max(right,left))+grid[row][col];
    }
}