class Solution {
    static int n;
    static int m;

    static int [][] dir={{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;

        List<List<Integer>> res=new ArrayList<>();

        boolean [][] pac=new boolean[n][m];
        boolean [][] atl=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            DFS(heights,i,0,-1,pac);
            DFS(heights,i,m-1,-1,atl);
        }

        for(int j=0;j<m;j++){
            DFS(heights,0,j,-1,pac);
            DFS(heights,n-1,j,-1,atl);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public static void DFS(int [][] heights,int i,int j,int prev,boolean [][] visited){
        
        if(i<0 || i>=n || j<0 || j>=m){
            return;
        }
        
        if(heights[i][j]<prev || visited[i][j]){
            return;
        }

        visited[i][j]=true;
        for(int [] d:dir){
            int ni=i+d[0];
            int nj=j+d[1];

            DFS(heights,ni,nj,heights[i][j],visited);
        }
    }
}