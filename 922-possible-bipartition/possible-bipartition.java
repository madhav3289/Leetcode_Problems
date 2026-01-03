class Solution {
    static List<List<Integer>> list;
    public boolean possibleBipartition(int n, int[][] edges) {
        // create adjacency list
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[0]-1).add(edge[1]-1);
            list.get(edge[1]-1).add(edge[0]-1);
        }
        // to keep a track of colors of all the nodes
        int [] color=new int[n];
        Arrays.fill(color,-1);   // mark all elements as -1, initially..
        for(int i=0;i<n;i++){
            // if node is unvisited, (for disconnected graph)
            if(color[i]==-1){
                // if we found the graph is not bipartite directly return false!
                boolean isValid=isBipartite(i,color);
                if(!isValid){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int node,int [] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);    // add the source node to queue
        color[node]=1;  // mark source node as 1
        while(!q.isEmpty()){
            // remove
            int u=q.poll();
            // add neighbours
            for(int nbrs:list.get(u)){
                // if both adjacent nodes has same color means our graph is not bipartite so return false
                // (we can't divide it into two subsets)..
                if(color[nbrs]==color[u]){
                    return false;
                }
                // if the neighbour is unvisited color it with opposite colour
                if(color[nbrs]==-1){
                    color[nbrs]=1-color[u];
                    q.add(nbrs);
                }                
            }
        }
        return true;
    }
}