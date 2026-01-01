class Solution {
    static List<List<Pair>> list;
    public int countRestrictedPaths(int n, int[][] edges) {
        // create an adjacency list
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int v1=edge[0]-1;
            int v2=edge[1]-1;
            int ct=edge[2];
            // add the edge with cost 
            list.get(v1).add(new Pair(v2,ct));
            list.get(v2).add(new Pair(v1,ct));
        }
        // store the shortest path distances from last node to all nodes
        int [] dist=dijkstra(n,n-1);

        // memoization to improve time complexity
        int [] dp=new int[n];
        Arrays.fill(dp,-1);
        // calculate and return total number of restricted paths through DFS..
        return DFS(dist,0,n-1,dp);
    } 
    static int mod=1_000_000_007;

    // DFS CODE>>
    public static int DFS(int [] dist,int src,int des,int [] dp){
        if(src==des){
            return 1;       // if we reach the last node return 1;
        }
        if(dp[src]!=-1){
            return dp[src];
        }
        int count=0;
        for(Pair p:list.get(src)){
            int nbr=p.vtx;
            // only if parent vertex has more distance than child vertex
            if(dist[src]>dist[nbr]){
                count=(count+DFS(dist,nbr,des,dp))%mod;
            }
        }
        return dp[src]=count;
    }
    public static int[] dijkstra(int n,int src){
        // distance array to store store shortest distance..
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;        // mark source node as 0
        // create a priority queue sorted by smallest cost on top.
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(src,0));        // add the source node to pq
        while(!pq.isEmpty()){
            // remove
            Pair p=pq.poll();
            int e=p.vtx;
            // add neighbours
            for(Pair nbrs:list.get(e)){
                int temp=nbrs.vtx;
                // calculate new distance
                int newDist=dist[e]+nbrs.cost;
                // if old distance is more replace it with lower one and also add it to pq.
                if(dist[temp]>newDist){
                    dist[temp]=newDist;
                    pq.add(new Pair(temp,newDist));
                }
            }
        }
        return  dist;
    }
    // implement a pair class to store neighbour vertex with the weight/cost..
    static class Pair{
        int vtx;    // neighbour vertex
        int cost;   // cost to reach neighbour vertex
        Pair(int vtx,int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}