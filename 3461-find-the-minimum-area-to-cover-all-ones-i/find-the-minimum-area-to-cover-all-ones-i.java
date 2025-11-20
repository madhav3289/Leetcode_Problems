class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int sr=n-1;   // first 1 in which row
        int er=0; // last 1 in which row
        int sc=m-1;   // first 1 in which col
        int ec=0; // last 1 in which col
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    sr=Math.min(sr,i);
                    sc=Math.min(sc,j);
                    er=Math.max(er,i);
                    ec=Math.max(ec,j);
                }
            }
        }
        int len=(ec-sc+1);
        int bth=(er-sr+1);
        return len*bth;
    }
}