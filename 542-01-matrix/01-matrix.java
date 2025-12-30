class Solution {
    static int[][] result;
    static int n;
    static int m;
    public int[][] updateMatrix(int[][] mat) {
        n=mat.length;
        m=mat[0].length;
        result=new int[n][m];
        for(int [] row:result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dijkstra(mat);
        return result;
    }
    public static void dijkstra(int [][] matrix){
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    result[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        boolean [][] visited=new boolean[n][m];
        int [][] distance={{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            // remove
            int [] cur=q.poll();
            int row=cur[0];
            int col=cur[1];
            // add neighbours
            for(int [] d:distance){
                int nRow=row+d[0];
                int nCol=col+d[1];
                if(nRow<0 || nCol<0 || nRow>=n || nCol>=m){
                    continue;
                }
                if(matrix[nRow][nCol]==0){
                    continue;
                }
                if(result[nRow][nCol]>result[row][col]+1){
                    result[nRow][nCol]=result[row][col]+1;
                    q.add(new int[]{nRow,nCol});
                }
            }
        }
    }
}