class Solution {
    static List<List<Integer>> list;
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // create adjacency list
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int v1=edge[0];
            int v2=edge[1];
            list.get(v1-1).add(v2-1);
            list.get(v2-1).add(v1-1);
        }
        // find the second shortest path using dijkastra..
        return dijkstra(n,time,change);
    }
    public static int dijkstra(int n,int time,int change){
        // to keep a track of shortest distance and second shortest distance
        int [][] dist=new int[n][2];
        // dist[i][0]->smallest
        // dist[i][1]->second smallest for vertex i
        for(int [] d:dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        dist[0][0]=0;   // smallest for source node is 0
        // PrioritQueue sorted by time(in ascending order)..
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});     // add the source node
        while(!pq.isEmpty()){
            // remove
            int [] e=pq.poll();
            int u=e[0];
            int timePassed=e[1];
            // ignore
            // add neighbours
            for(int nbrs:list.get(u)){
                // find in which interval the current time lies
                int div=(timePassed/change);
                int newTime=0;
                // if it is even means signal is green, so we are good to go
                // so, just add the prevtime and time to travel from one node to other
                if(div%2==0){
                    newTime=timePassed+time;
                }
                // if it is odd, means signal is red so we need to wait till it turns green
                // so wait till next interval ends.
                else{
                    newTime=(div+1)*change+time;
                }
                // if value is less than smallest time replace second smallest by smallest and smallest by current(new time).
                if(newTime<dist[nbrs][0]){
                    dist[nbrs][1]=dist[nbrs][0];
                    dist[nbrs][0]=newTime;
                    pq.add(new int[]{nbrs,newTime});
                }
                // if value is larger than smallest time but less than second smallest just replace the second smallest..
                else if(newTime>dist[nbrs][0] && newTime<dist[nbrs][1]){
                    dist[nbrs][1]=newTime;
                    pq.add(new int[]{nbrs,newTime});
                }
            }
        }
        // return the second shortest distance for the last node..
        return dist[n-1][1];
    }
}