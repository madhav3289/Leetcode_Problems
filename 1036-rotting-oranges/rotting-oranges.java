class Solution {
    static int n;
    static int m;
    public int orangesRotting(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int [][] timing=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    BFS(grid,i,j,timing);
                }
            }
        }
        int time=0;
        boolean isValid=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && timing[i][j]==0){
                    isValid=false;
                    break;
                }
                time=Math.max(time,timing[i][j]);
            }
            if(!isValid){
                break;
            }
        }
        return (isValid)?time:-1;
    }
    public static void BFS(int [][] grid,int r,int c,int [][] timing){
        // {up,left,down,right};
        int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
        // {row,col,time};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c,0});
        while(!q.isEmpty()){
            // remove from queue
            int [] e=q.poll();
            int row=e[0];
            int col=e[1];
            int time=e[2];
            // mark the time
            timing[row][col]=time;
            // add neighbouring elements
            for(int [] dir:direction){
                int nRow=row+dir[0];
                int nCol=col+dir[1];
                int nTime=time+1;
                // 
                if(nRow<0 || nCol<0 ||nRow>=n || nCol>=m){
                    continue;
                }
                if(grid[nRow][nCol]==0 || grid[nRow][nCol]==2){
                    continue;
                }
                if(timing[nRow][nCol]!=0 && timing[nRow][nCol]<=nTime){
                    continue;
                }
                q.add(new int[]{nRow,nCol,nTime});
            }
        }        
    }
}