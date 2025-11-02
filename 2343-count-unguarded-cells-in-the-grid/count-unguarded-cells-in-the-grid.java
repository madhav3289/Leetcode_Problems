class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] grid=new int[m][n];
        for(int i=0;i<guards.length;i++){
            int r=guards[i][0];
            int c=guards[i][1];
            grid[r][c]=2;
        }
        for(int i=0;i<walls.length;i++){
            int r=walls[i][0];
            int c=walls[i][1];
            grid[r][c]=3;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    // left
                    for(int x=j-1;x>=0;x--){
                        if(grid[i][x]==3 || grid[i][x]==2){
                            break;
                        }
                        if(grid[i][x]==0){
                            grid[i][x]=1;
                        }                        
                    }

                    // right
                    for(int x=j+1;x<n;x++){
                        if(grid[i][x]==3 || grid[i][x]==2){
                            break;
                        }
                        if(grid[i][x]==0){
                            grid[i][x]=1;
                        }
                    }

                    // up
                    for(int x=i-1;x>=0;x--){
                        if(grid[x][j]==3 || grid[x][j]==2){
                            break;
                        }
                        if(grid[x][j]==0){
                            grid[x][j]=1;
                        }                        
                    }

                    // down
                    for(int x=i+1;x<m;x++){
                        if(grid[x][j]==3 || grid[x][j]==2){
                            break;
                        }
                        if(grid[x][j]==0){
                            grid[x][j]=1;
                        }
                    }                    
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}