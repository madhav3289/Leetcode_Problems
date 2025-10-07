class Solution {
    static int n;
    static int m;
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int [][] dp=new int[n][m];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,helper(matrix,i,j,-1,dp));
            }
        }
        return max;
    }
    public static int helper(int [][] matrix,int i,int j,int num,int [][] dp){
        if(i<0 || j<0 || i>=n || j>=m){
            return 0;
        }
        if(matrix[i][j]<=num){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int cur=matrix[i][j];
        int l=1+helper(matrix,i,j-1,cur,dp);
        int r=1+helper(matrix,i,j+1,cur,dp);
        int d=1+helper(matrix,i+1,j,cur,dp);
        int u=1+helper(matrix,i-1,j,cur,dp);

        return dp[i][j]=Math.max(l,Math.max(r,Math.max(d,u)));
    }
}