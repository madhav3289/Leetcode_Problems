class Solution {
    static int n;
    static int m;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n=grid.size();
        m=grid.get(0).size();
        // array to keep a track of health at particular index
        int [][] healthRem=new int[n][m];
        // find a valid path using BFS
        return BFS(grid,health,healthRem);
    }
    public static boolean BFS(List<List<Integer>> grid, int health,int [][] healthRem){
        // create an array of directions..
        int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};      // {up,left,down,right}
        Queue<int[]> q=new LinkedList<>();
        // add the first cell in queue..
        q.add(new int[]{0,0});
        // assign health of first cell
        healthRem[0][0]=(grid.get(0).get(0)==1)?health-1:health;    
        while(!q.isEmpty()){
            // 1. remove from queue
            int [] temp=q.poll();
            int row=temp[0];
            int col=temp[1];

            // 2. self-work (we have reached the last element with health greater than equal to 1 so return true i.e path exists..)
            if(row==n-1 && col==m-1 && healthRem[row][col]>=1){
                return true;
            }

            // 3. add neighbours of current cell
            for(int [] dir:direction){
                int nRow=row+dir[0];        // new row
                int nCol=col+dir[1];        // new col
                // if current row and col is out of bound continue..
                if(nRow<0 || nCol<0 || nRow>=n || nCol>=m){
                    continue;
                }
                int nHealth=healthRem[row][col];
                // if current sell is 1 we decrease the health by 1
                if(grid.get(nRow).get(nCol)==1){
                    nHealth-=1;
                }
                // if health becomes equal to 0 then we can't move further so no need to take current column
                if(nHealth<=0){
                    continue;
                }
                // if health of new cell is less than new health we assign the new health and add that to queue..
                if(healthRem[nRow][nCol]<nHealth){
                    healthRem[nRow][nCol]=nHealth;
                    q.add(new int[]{nRow,nCol});
                }
            }
        }
        return false;
    }
}