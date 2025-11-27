class Solution {
    static boolean [][] visited;
    public int numIslands(char[][] maze) {
        int n=maze.length;
        int m=maze[0].length;
        visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maze[i][j]=='1' && !visited[i][j]){
                    DFS(maze,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void DFS(char [][] maze,int r,int c){
        if(r<0 || c<0 || r>=maze.length || c>=maze[0].length){
            return;
        }
        if(visited[r][c] || maze[r][c]=='0'){
            return;
        }
        visited[r][c]=true;
        DFS(maze,r-1,c);
        DFS(maze,r,c-1);
        DFS(maze,r+1,c);
        DFS(maze,r,c+1);
    }
}