class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
        return;
    }
    public static boolean helper(char [][] board,int row,int col){
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            return true;
        }
        if(board[row][col]!='.'){
            return helper(board,row,col+1);
        }
        else{
            for(int i=1;i<10;i++){
                char ch=(char)(i+'0');
                if(isValid(board,row,col,ch)){
                    board[row][col]=ch;
                    if(helper(board,row,col+1)){
                        return true;
                    }
                    board[row][col]='.';
                }
            }
        }
        return false;
    }
    public static boolean isValid(char [][] board,int row,int col,char ch){
        // that entire col
        for(int i=0;i<9;i++){
            if(ch==board[row][i]){
                return false;
            }
        }
        // that entire row
        for(int i=0;i<9;i++){
            if(ch==board[i][col]){
                return false;
            }
        }
        // 3x3 matrix
        int r=row-row%3;
        int c=col-col%3;
        for(int i=r;i<3+r;i++){
            for(int j=c;j<3+c;j++){
                if(ch==board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }    
}