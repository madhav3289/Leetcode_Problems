class Solution {
    static int n;
    static int m;
    public void solve(char[][] board) {
        n=board.length;
        m=board[0].length;
        // check on boundry if that element is 0
        boolean [][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            // for first and last rows we need to check every column
            if(i==0 || i==n-1){
                for(int j=0;j<m;j++){
                    if(!visited[i][j]){
                        BFS(board,visited,i,j);
                    }
                }
            }
            // for the middle rows, we only need to check first and last column of that row
            else{
                // first column
                if(!visited[i][0]){
                    BFS(board,visited,i,0);
                }
                // last column
                if(!visited[i][m-1]){
                    BFS(board,visited,i,m-1);
                }
            }
        }
        // mark all elements 'X', if they are unvisited..
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
        return;
    }
    public static void BFS(char [][] board,boolean [][] visited,int row,int col){
        // we can move in any four direction >> {up,left,down,right}
        int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q=new LinkedList<>();
        // add current element in queue
        q.add(new int[]{row,col});
        while(!q.isEmpty()){
            // remove from queue
            int [] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            // ignore
            if(board[r][c]=='X' || visited[r][c]){
                continue;       // this is already visited, we don't need to check it!
            }
            // mark visited
            visited[r][c]=true;     // to know in future if we have already visited
            // add neighbours
            for(int [] dir:direction){
                int cRow=r+dir[0];
                int cCol=c+dir[1];
                // make sure that row and col is within range...
                if(cRow<0 || cCol<0 || cRow>=n || cCol>=m){
                    continue;
                }
                // so that we don't add the visited column(We can check this here also!!)
                // if(board[r][c]=='X' || visited[cRow][CCol]){
                //     continue;
                // }
                q.add(new int[]{cRow,cCol});
            }
        }
        return;
    }
}