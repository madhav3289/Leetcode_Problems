class Solution {
    static int n;
    static int m;
    static int totalSteps;
    public int uniquePathsIII(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        totalSteps=0;
        int row=0,col=0;
        boolean [][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    totalSteps++;
                }
                else if(grid[i][j]==1){
                    row=i;
                    col=j;
                }
            }
        }
        return helper(grid,row,col,visited,-1);
        
    }
    public static int helper(int [][] grid,int row,int col,boolean [][] isVisited,int cSteps){
        if(row<0 || col<0 || row>=n || col>=m){
            return 0;
        }
        if(grid[row][col]==-1 || isVisited[row][col]){
            return 0;
        }
        if(grid[row][col]==2){
            if(cSteps==totalSteps){
                return 1;
            }
            return 0;
        }
        int count=0;
        isVisited[row][col]=true;
        count+=helper(grid,row,col-1,isVisited,cSteps+1);
        count+=helper(grid,row-1,col,isVisited,cSteps+1);
        count+=helper(grid,row,col+1,isVisited,cSteps+1);
        count+=helper(grid,row+1,col,isVisited,cSteps+1);
        isVisited[row][col]=false;
        return count;
    }
}