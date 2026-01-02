class Solution {
    static int n;
    static int m;
    public int minimumEffortPath(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        // find the minimum and maximum from the matrix as the answer lies between it.
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,heights[i][j]);
            }
        }
        // do a binary search and on the answer\
        int lo=0;
        int hi=max;
        int ans=max;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            // if it is possible, look for more smaller answer..
            if(isPossible(mid,heights)){
                ans=mid;
                hi=mid-1;
            }
            // if still not possible look for a higher answer..
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    // find the path using BFS
    public static boolean isPossible(int value,int [][] grid){
        // direction array >> {up,left,down,right}
        int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
        // to keep a track of visited columns
        boolean [][] visited=new boolean[n][m];

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});      // add the first cell
        while(!q.isEmpty()){
            // remove from queue
            int [] e=q.poll();
            int row=e[0];
            int col=e[1];
            // ignore if already visited
            if(visited[row][col]){
                continue;
            }
            // mark the current cell visited
            visited[row][col]=true;
            // self-work(return if we reach the last cell)
            if(row==n-1 && col==m-1){
                return true;
            }
            // add the neighbouring elements
            for(int [] dir:direction){
                int nRow=row+dir[0];
                int nCol=col+dir[1];
                // check if the new cell is under bound
                if(nRow<0 || nCol<0 || nRow>=n || nCol>=m){
                    continue;
                }
                // if column is already visited or the absolute differnce between parent cell and current cell is more than value then continue..
                if(visited[nRow][nCol] || Math.abs(grid[nRow][nCol]-grid[row][col])>value){
                    continue;
                }
                // add the new cell to queue
                q.add(new int[]{nRow,nCol});
            }
        }
        // we can't reach last index..
        return false;
    }
}