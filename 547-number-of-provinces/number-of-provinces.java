class Solution {
    static List<List<Integer>> list;
    static int n;
    public int findCircleNum(int[][] isConnected) {
        list=new ArrayList<>();
        n=isConnected.length;
        // create adjacency list using matrix
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    list.get(i).add(j);
                }
            }
        }
        int count=0;    // to count the number of provinces
        boolean [] visited=new boolean[n];
        for(int i=0;i<n;i++){
            // if this node is unvisited then again do a BFS
            if(!visited[i]){
                count++;    // increase the count since it is seperate province
                BFS(i,visited);
            }
        }
        return count;
    }
    public static void BFS(int node,boolean [] visited){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
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
            // add neighbours
            for(int i=0;i<list.get(e).size();i++){
                int temp=list.get(e).get(i);
                if(!visited[temp]){
                    q.add(temp);
                }
            }
        }
    }
}