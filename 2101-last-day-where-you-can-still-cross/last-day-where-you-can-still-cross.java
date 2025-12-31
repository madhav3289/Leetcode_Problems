class Solution {
    static int n;
    static int m;
    public int latestDayToCross(int row, int col, int[][] cells) {
        n=row;m=col;
        // do a binary search on cells to find at wich last index it is possible to cross
        int lo=0;
        int hi=cells.length-1;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            // check if it is possible till mid;
            // if yes, store the resultant and look for higher day where it is possible
            if(isPossible(mid,cells)){
                ans=mid;
                lo=mid+1;
            }
            // if false means look for smaller answer
            else{
                hi=mid-1;
            }
        }
        // return the answer
        return ans+1;
    }
    public static boolean isPossible(int mid,int [][] cells){
        // mark the columns till current index
        int [][] grid=new int[n][m];
        for(int i=0;i<=mid;i++){
            int row=cells[i][0]-1;
            int col=cells[i][1]-1;
            grid[row][col]=1;
        }
        // look if it possible to reach the last row..
        boolean hasPath=false;
        for(int i=0;i<m;i++){
            // check only if value is 0
            if(grid[0][i]==0){
                hasPath=BFS(grid,i);
                // if there is a path directly return true..
                if(hasPath){
                    return true;
                }
            }
        }
        // since no path exists, so return false..
        return false;
    }
    // code for bfs
    public static boolean BFS(int [][] grid,int c){
        // direction array >> {up,left,down,right}
        int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
        // to keep a track of visited elements..
        boolean [][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        // add the current cell in queue
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
            // mark visit the current cell
            visited[row][col]=true;
            // if we have reach the last row, it means there is a path so return true..
            if(row==n-1){
                return true;
            }
            // add neighbours of the current cell..
            for(int [] dir:direction){
                int nRow=row+dir[0];
                int nCol=col+dir[1];
                // if current row and col is out of bound continue..
                if(nRow<0 || nCol<0 || nRow>=n || nCol>=m){
                    continue;
                }
                // if cell is already visited or it's value is 1 continue..
                if(visited[nRow][nCol] || grid[nRow][nCol]==1){
                    continue;
                }
                // add the new cell in queue
                q.add(new int[]{nRow,nCol});
            }
        }
        // if no path exists, return false!!
        return false;
    }
}