class Solution {
    public int maximalNetworkRank(int n, int[][] edges) {
        int [][] graph=new int[n][n];
        int [] freq=new int[n];
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            freq[u]++;
            freq[v]++;
            graph[u][v]=1;
            graph[v][u]=1;
        }
        int maxNet=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int count=freq[i]+freq[j]-graph[i][j];
                maxNet=Math.max(maxNet,count);
            }
        }
        return maxNet;
    }
}