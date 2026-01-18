class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        // prefix sum of rows
        int [][] rowPref=new int[n][m];
        for(int i=0;i<n;i++){
            rowPref[i][0]=grid[i][0];
            for(int j=1;j<m;j++){
                rowPref[i][j]=rowPref[i][j-1]+grid[i][j];
            }
        }
        // prefix sum of columns
        int [][] colPref=new int[n][m];
        for(int j=0;j<m;j++){
            colPref[0][j]=grid[0][j];
            for(int i=1;i<n;i++){
                colPref[i][j]=colPref[i-1][j]+grid[i][j];
            }
        }
        // iterate over side
        for(int side=Math.min(m,n);side>=2;side--){
            for(int i=0;i+side-1<n;i++){
                for(int j=0;j+side-1<m;j++){
                    // calulate the sum of current segment
                    int ogSum=rowPref[i][j+side-1]-(j>0?rowPref[i][j-1]:0);

                    boolean isValid=true;
                    // check for all other segment of rows if sum is equal or not
                    for(int k=i+1;k<i+side;k++){
                        int newSum=rowPref[k][j+side-1]-(j>0?rowPref[k][j-1]:0);
                        if(newSum!=ogSum){
                            isValid=false;
                            break;
                        }
                    }
                    // if the sum isn't equal to original continue (current square wasn't magical)
                    if(!isValid) continue;

                    // check for all segments of cols if sum is equal or not
                    for(int k=j;k<j+side;k++){
                        int newSum=colPref[i+side-1][k]-(i>0?colPref[i-1][k]:0);
                        if(newSum!=ogSum){
                            isValid=false;
                            break;
                        }
                    }
                    if(!isValid) continue;

                    // check of both the diagonal
                    int leftD=0,rightD=0;
                    for(int k=0;k<side;k++){
                        leftD+=grid[i+k][j+k];
                        rightD+=grid[i+k][j+side-1-k];
                    }
                    if(leftD==ogSum && rightD==ogSum){
                        return side;
                    }
                }
            }
        }
        return 1;
    }
}