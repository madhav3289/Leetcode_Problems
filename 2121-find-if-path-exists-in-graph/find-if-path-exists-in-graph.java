class Solution {
    static List<List<Integer>> list;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        return BFS(n,source,destination);
    }
    public static boolean BFS(int n,int src,int des){
        boolean [] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            // remove
            int e=q.poll();
            // ignore
            if(visited[e]){
                continue;
            }
            // mark visited
            visited[e]=true;
            // self-work
            if(e==des){
                return true;
            }
            // add neighbours
            for(int nbr:list.get(e)){
                if(!visited[nbr]){
                    q.add(nbr);
                }
            }
        }
        return false;
    }
}