class Solution {
    static List<List<Integer>> list;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // create adjacency list
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        // do a BFS from source 
        return BFS(n,source,destination);
    }
    public static boolean BFS(int n,int src,int des){
        boolean [] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);     // add source node
        while(!q.isEmpty()){
            // remove
            int e=q.poll();
            // ignore if already visited
            if(visited[e]){
                continue;
            }
            // mark the current element visited
            visited[e]=true;
            // return true if we have reached the destination
            if(e==des){
                return true;
            }
            // add neighbours of the current vertex
            for(int nbr:list.get(e)){
                if(!visited[nbr]){
                    q.add(nbr);
                }
            }
        }
        // we have exited before reaching the destination means it's impossible to reach destination so return false..
        return false;
    }
}