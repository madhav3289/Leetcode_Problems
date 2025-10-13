class Solution {

    static int n;
    static int m;

    public int uniquePathsIII(int[][] grid) {
        // we have to walk over each and every empty squares and reach a target.

        n=grid.length;
        m=grid[0].length;
        boolean [][] isVisited=new boolean[n][m];

        int t_steps=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    t_steps++;
                }
            }
        }

        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    res+=helper(grid,isVisited,t_steps+1,0,i,j);
                }
            }
        }
        return res;
    }
    public static int helper(int [][] grid,boolean [][] isVisited,int t_steps,int c_steps,int i,int j){
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(grid[i][j]==-1 || isVisited[i][j]){
            return 0;
        }
        if(grid[i][j]==2){
            if(t_steps==c_steps){
                return 1;
            }
            return 0;
        }
        int count=0;
        isVisited[i][j]=true;
        count+=helper(grid,isVisited,t_steps,c_steps+1,i,j-1);        
        count+=helper(grid,isVisited,t_steps,c_steps+1,i-1,j);        
        count+=helper(grid,isVisited,t_steps,c_steps+1,i,j+1);        
        count+=helper(grid,isVisited,t_steps,c_steps+1,i+1,j);
        isVisited[i][j]=false;
        return count;
    }
}