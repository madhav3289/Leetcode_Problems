class Solution {
    static List<List<Pair>> list;
    public int networkDelayTime(int[][] times, int n, int k) {
        list=new ArrayList<>();
        // 1. create adjacency list
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] time:times){
            int v1=time[0];
            int v2=time[1];
            int cost=time[2];
            list.get(v1-1).add(new Pair(v2-1,cost));
        }
        // using dijkstra algorithm compute distance from source to every node
        return Dijkstra(n,k-1);
    }
    public static int Dijkstra(int n,int src){
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);    // initialise with maximum value
        dist[src]=0;
        // create priority queue sorted by cost/weight
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(src,0));    // add source node..
        while(!pq.isEmpty()){
            // remove
            Pair p=pq.poll();
            int v=p.nvtx;
            int d=p.cost;
            // ignore
            // mark visited
            // self work
            // add neighbours
            for(int i=0;i<list.get(v).size();i++){
                Pair e=list.get(v).get(i);
                int vtx=e.nvtx;
                int wt=e.cost;
                int nDist=wt+d;
                if(nDist<dist[vtx]){
                    dist[vtx]=nDist;
                    pq.add(new Pair(e.nvtx,nDist));
                }
            }
        }
        // find the maximum value from the distance, so we can reach every node
        // if value at any node is Int.MAX we never reach that vertex so return -1
        // else return maximum element
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,dist[i]);
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }
    static class Pair{
        int nvtx;
        int cost;
        Pair(int nvtx,int cost){
            this.nvtx=nvtx;
            this.cost=cost;
        }
    }
}