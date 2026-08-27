class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] temp:flights){
            int u=temp[0];
            int v=temp[1];
            int c=temp[2];
            graph.get(u).add(new int[]{v,c});
        }

        return BFS(src,dst,k,graph,n);
    }

    public int BFS(int src,int des,int k,List<List<int[]>> graph,int n){

        int [] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0,-1});

        while(!q.isEmpty()){

            int [] temp=q.poll();
            int u=temp[0];
            int cost=temp[1];
            int opr=temp[2];

            for(int [] nbrs:graph.get(u)){
                int v=nbrs[0];
                int newCost=nbrs[1]+cost;

                if(v==des){
                    if(opr+1<=k){
                        dp[des]=Math.min(dp[des],newCost);
                    }
                    continue;
                }

                if(dp[v]>newCost){
                    dp[v]=newCost;
                    q.add(new int[]{v,newCost,opr+1});
                }
            }

        }

        return (dp[des]==Integer.MAX_VALUE)?-1:dp[des];
    }

}