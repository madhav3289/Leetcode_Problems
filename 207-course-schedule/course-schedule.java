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
        // calculate indegree of every node
        int [] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<list.get(i).size();j++){
                int e=list.get(i).get(j);
                indegree[e]++;
            }
        }
        // topological sort
        return BFS(n,indegree);
    }
    public static boolean BFS(int n,int [] indegree){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            // remove
            int e=q.poll();
            // ignore
            // add neighbours
            for(int nbrs:list.get(e)){
                indegree[nbrs]--;
                if(indegree[nbrs]==0){
                    q.add(nbrs);
                }
            }
            // add to arraylist
            res.add(e);
        }
        return res.size()==n;
    }
}