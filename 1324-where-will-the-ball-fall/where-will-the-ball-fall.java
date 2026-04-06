class Solution {
    public int[] findBall(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [] res=new int[m];
        for(int i=0;i<m;i++){
            res[i]=solve(i,grid,n,m);
        }
        return res;
    }
    public static int solve(int col,int [][] grid,int n,int m){
        if(col==0 && grid[0][0]==-1){
            return -1;
        }
        if(col==m-1 && grid[0][m-1]==1){
            return -1;
        }
        int r=0;
        int c=col;
        while(r<n && c<m){
            if(grid[r][c]==1){
                if(c==m-1){
                    return -1;
                }
                if(c<m-1 && grid[r][c+1]==-1){
                    return -1;
                }
                c++;
                r++;
            }
            else if(grid[r][c]==-1){
                if(c==0){
                    return -1;
                }
                if(c>0 && grid[r][c-1]==1){
                    return -1;
                }
                r++;
                c--;
            }
        }
        return c;
    }
}