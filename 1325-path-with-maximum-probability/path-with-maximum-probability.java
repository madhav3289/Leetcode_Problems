class Solution {
    static List<List<Pair>> list;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // create a adjacency list
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int idx=0;
        for(int [] edge:edges){
            list.get(edge[0]).add(new Pair(edge[1],succProb[idx]));
            list.get(edge[1]).add(new Pair(edge[0],succProb[idx]));
            idx++;
        }
        // find the path using dijkstra algo..
        return dijkstra(n,start,end);
    }
    public static double dijkstra(int n,int src,int des){
        // keeping a track of highest probability from every edge..
        double [] vtxProb=new double[n];
        Arrays.fill(vtxProb,Double.MIN_VALUE);
        vtxProb[src]=(double)1;
        // queue to keep track of edges giving priority to highest probability..
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        // adding source node
        pq.add(new Pair(src,(double)1));
        while(!pq.isEmpty()){
            // remove from queue
            Pair p=pq.poll();
            int u=p.vtx;
            // add neighbours
            for(Pair nbrs:list.get(u)){
                // calculate the cost of neighbouring vertex
                double newProb=(double)nbrs.prob*vtxProb[u];
                // if probability at neighbouring vertex is lower replace it with higher one and add that to priority queue
                if(vtxProb[nbrs.vtx]<newProb){
                    vtxProb[nbrs.vtx]=newProb;
                    pq.add(new Pair(nbrs.vtx,newProb));
                }
            }
        }
        // if the value at destination vertex is min value means we never reach that node so return 0 else return the probability at that node..
        return (vtxProb[des]==Double.MIN_VALUE)?0:vtxProb[des];
    }
    // create a pair class for neighbour vertex with weight(probability).
    static class Pair{
        int vtx;
        double prob;
        Pair(int vtx,double prob){
            this.vtx=vtx;
            this.prob=prob;
        }
    }
}