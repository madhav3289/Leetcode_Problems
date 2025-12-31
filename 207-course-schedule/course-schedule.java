class Solution {
    static List<List<Integer>> list;
    public boolean canFinish(int n, int[][] edges) {
        list=new ArrayList<>();
        // create adjacency list
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[1]).add(edge[0]);
        }
        // to keep a track of visited elements
        boolean [] visited=new boolean[n];
        // to keep of a track of elements in a path
        boolean [] parent=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(DFS(i,visited,parent)){
                    return false;   // cycle exists..
                }
            }
        }
        return true;
    }
    public static boolean DFS(int node,boolean [] visited,boolean [] parent){
        parent[node]=true;
        visited[node]=true;
        for(int nbrs:list.get(node)){
            // this element is already in path so cycle exists return false..
            if(parent[nbrs]){
                return true;
            }
            // add only the unvisited elements..
            if(!visited[nbrs]){
                if(DFS(nbrs,visited,parent)){
                    return true;
                }
            }
        }
        // backtrack
        parent[node]=false;
        return false;
    }
}
    // public boolean canFinish(int n, int[][] edges) {
    //     list=new ArrayList<>();
    //     // create adjacency list
    //     for(int i=0;i<n;i++){
    //         list.add(new ArrayList<>());
    //     }
    //     for(int [] edge:edges){
    //         list.get(edge[1]).add(edge[0]);
    //     }
    //     // calculate indegree of every node
    //     int [] indegree=new int[n];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<list.get(i).size();j++){
    //             int e=list.get(i).get(j);
    //             indegree[e]++;
    //         }
    //     }
    //     // topological sort
    //     return BFS(n,indegree);
    // }
    // public static boolean BFS(int n,int [] indegree){
    //     Queue<Integer> q=new LinkedList<>();
    //     for(int i=0;i<n;i++){
    //         if(indegree[i]==0){
    //             q.add(i);
    //         }
    //     }
    //     List<Integer> res=new ArrayList<>();
    //     while(!q.isEmpty()){
    //         // remove
    //         int e=q.poll();
    //         // ignore
    //         // add neighbours
    //         for(int nbrs:list.get(e)){
    //             indegree[nbrs]--;
    //             if(indegree[nbrs]==0){
    //                 q.add(nbrs);
    //             }
    //         }
    //         // add to arraylist
    //         res.add(e);
    //     }
    //     return res.size()==n;
    // }
// }