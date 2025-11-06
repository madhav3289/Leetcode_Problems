class Solution {
    public boolean isValidSudoku(char[][] board) {
        return helper(board,0,0);
    }
    public static boolean helper(char [][] board,int row,int col){
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            return true;
        }
        if(board[row][col]=='.'){
            return helper(board,row,col+1);
        }
        else{
            if(!isValid(board,row,col)){
                return false;
            }
        }
        return helper(board,row,col+1);
    }
    public static boolean isValid(char [][] board,int row,int col){
        // that entire col
        for(int i=0;i<9;i++){
            if(i!=col && board[row][col]==board[row][i]){
                return false;
            }
        }
        // that entire row
        for(int i=0;i<9;i++){
            if(i!=row && board[row][col]==board[i][col]){
                return false;
            }
        }
        // 3x3 matrix
        int r=row-row%3;
        int c=col-col%3;
        for(int i=r;i<3+r;i++){
            for(int j=c;j<3+c;j++){
                if(i!=row && j!=col && board[row][col]==board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}