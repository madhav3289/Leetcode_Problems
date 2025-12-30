class Solution {
    static List<List<Pair>> list;
    public int minCost(int n, int[][] edges) {
        list=new ArrayList<>();
        // create a adjacency matrix
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            // add the original pair of edge & weight
            list.get(edge[0]).add(new Pair(edge[1],edge[2]));
            // also add the pair of reverse edge & 2*weight
            list.get(edge[1]).add(new Pair(edge[0],2*edge[2]));
        }
        // find shortest distance from src(0) to dest(n-1) using dijkstra algo..
        return dijkstra(n);
    }
    public static int dijkstra(int n){
        // create a distance array to calculate shortest distance 
        // and initialise it with maximum integer value;
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            // remove
            Pair e=pq.poll();
            // ignore
            // mark visited
            // self-work
            if(e.vtx==n-1){
                break;
            }
            // add neighbours
            for(Pair p:list.get(e.vtx)){
                int d=p.cost+dist[e.vtx];
                if(dist[p.vtx]>d){
                    dist[p.vtx]=d;
                    pq.add(new Pair(p.vtx,d));
                }
            }
        }
        return (dist[n-1]==Integer.MAX_VALUE)?-1:dist[n-1];
    }
    static class Pair{
        int vtx;
        int cost;
        Pair(int vtx,int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}