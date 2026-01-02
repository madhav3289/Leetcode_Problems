class Solution {
    static List<List<Pair>> list;
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // create adjacency list
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int v1=edge[0];
            int v2=edge[1];
            int ct=edge[2];
            list.get(v1).add(new Pair(v2,ct));
            list.get(v2).add(new Pair(v1,ct));
        }
        // find the shortest path using dijkstra..
        return dijkstra(n,0,disappear);
    }
    public static int [] dijkstra(int n,int src,int [] disTime){
        // to keep a track of shortest distances/time
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;    // mark the source node 0
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(src,0));    // add the source node
        while(!pq.isEmpty()){
            // remove the pair
            Pair p=pq.poll();
            int u=p.vtx;
            // ignore
            if(p.cost>dist[u]){
                continue;
            }
            if(p.cost>=disTime[u]){
                continue;
            }
            // add the neighbouring elements
            for(Pair nbrs:list.get(u)){
                int v=nbrs.vtx;
                int newTime=nbrs.cost+dist[u];
                if(newTime>=disTime[v]){
                    continue;
                }
                if(newTime<dist[v]){
                    dist[v]=newTime;
                    pq.add(new Pair(v,newTime));
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }

    // implement a pair class 
    static class Pair{
        int vtx;
        int cost;
        Pair(int vtx,int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}