class Solution {
    static int n;
    static int m;
    public int latestDayToCross(int row, int col, int[][] cells) {
        n=row;
        m=col;
        // do a binary search on cells to find at wich last index it is possible to cross
        int lo=0;
        int hi=cells.length-1;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(mid,cells)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans+1;
    }
    public static boolean isPossible(int mid,int [][] cells){
        int [][] grid=new int[n][m];
        for(int i=0;i<=mid;i++){
            int row=cells[i][0]-1;
            int col=cells[i][1]-1;
            grid[row][col]=1;
        }
        boolean hasPath=false;
        for(int i=0;i<m;i++){
            if(grid[0][i]==0){
                hasPath=BFS(grid,i);
                if(hasPath){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean BFS(int [][] grid,int c){
        int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
        boolean [][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,c});
        while(!q.isEmpty()){
            // remove from queue
            int [] p=q.poll();
            int row=p[0];
            int col=p[1];
            // ignore if already visited
            if(visited[row][col]){
                continue;
            }
            // mark visited
            visited[row][col]=true;
            // self-work
            if(row==n-1){
                return true;
            }
            // add neighbours
            for(int [] dir:direction){
                int nRow=row+dir[0];
                int nCol=col+dir[1];
                if(nRow<0 || nCol<0 || nRow>=n || nCol>=m){
                    continue;
                }
                if(visited[nRow][nCol] || grid[nRow][nCol]==1){
                    continue;
                }
                q.add(new int[]{nRow,nCol});
            }
        }
        return false;
    }
}