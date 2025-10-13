class Solution {
    static int n;
    static int m;
    public int getMaximumGold(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        boolean [][] isVisited=new boolean[n][m];

        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    continue;
                }
                else{
                    max=Math.max(max,helper(grid,i,j,isVisited));
                }
            }
        }
        return max;
    }
    public static int helper(int [][] grid,int i,int j,boolean [][] isVisited){
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(grid[i][j]==0 || isVisited[i][j]){
            return 0;
        }
        isVisited[i][j]=true;
        int left=helper(grid,i,j-1,isVisited);
        int up=helper(grid,i-1,j,isVisited);
        int right=helper(grid,i,j+1,isVisited);
        int down=helper(grid,i+1,j,isVisited);
        isVisited[i][j]=false;
        return grid[i][j]+Math.max(Math.max(up,down),Math.max(right,left));
    }
}