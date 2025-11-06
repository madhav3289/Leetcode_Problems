class Solution {
    static int n;
    static int m;
    public boolean exist(char[][] board, String word) {
        n=board.length;
        m=board[0].length;
        boolean [][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    if(helper(board,word,visited,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean helper(char [][] board,String word,boolean [][] visited,int row,int col,int idx){
        if(idx==word.length()){
            return true;
        }
        if(row<0 || col<0 || row>=n || col>=m){
            return false;
        }
        if(word.charAt(idx)!=board[row][col] || visited[row][col]){
            return false;
        }
        visited[row][col]=true;
        boolean up=helper(board,word,visited,row-1,col,idx+1);
        boolean left=helper(board,word,visited,row,col-1,idx+1);
        boolean down=helper(board,word,visited,row+1,col,idx+1);
        boolean right=helper(board,word,visited,row,col+1,idx+1);
        if(up || left || down || right){
            return true;
        }
        visited[row][col]=false;
        return false;
    }
}