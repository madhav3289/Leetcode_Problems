class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        Set<String> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !set.contains(i+" "+j)){
                    count++;
                    helper(grid,set,i,j);
                }
            }
        }
        return count;
    }
    public static void helper(char [][] grid,Set<String> set,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        if(set.contains(i+" "+j)){
            return;
        }
        else{
            set.add(i+" "+j);
            helper(grid,set,i-1,j);
            helper(grid,set,i,j-1);
            helper(grid,set,i+1,j);
            helper(grid,set,i,j+1);
        }
    }
}