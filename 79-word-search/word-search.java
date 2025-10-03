class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean [][] isUsed=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,i,j,isUsed,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean helper(char [][] board,String word,int i,int j,boolean [][] isUsed,int idx){
        
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(word.charAt(idx)!=board[i][j]){
            return false;
        }
        if(isUsed[i][j]){
            return false;
        }
        isUsed[i][j]=true;
        boolean a=helper(board,word,i-1,j,isUsed,idx+1);
        boolean b=helper(board,word,i,j-1,isUsed,idx+1);
        boolean c=helper(board,word,i+1,j,isUsed,idx+1);
        boolean d=helper(board,word,i,j+1,isUsed,idx+1);
        if(a || b || c || d){
            return true;
        }
        isUsed[i][j]=false;
        return false;
    }
}