class Solution {
    static List<List<Integer>> list;
    public int minimumTime(int n, int[][] rel, int[] time) {
        list=new ArrayList<>();
        // 1. Create adjacency list
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<rel.length;i++){
            int v1=rel[i][0];
            int v2=rel[i][1];
            list.get(v1-1).add(v2-1);   // use 0-based indexing for simplicity
        }

        // 2. Compute the indegree for every vertex
        int [] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int v:list.get(i)){
                indegree[v]+=1;
            }
        }

        int [] prevTime=new int[n];     // create prevTime list to store the maximum time before any vertex;
        // 3. Topological Sort (Using BFS >> Kahn's Algorithm
        BFS(prevTime,indegree,time);

        int ans=0;
        // 4. Compute time required till every vertex
        for(int i=0;i<n;i++){
            prevTime[i]+=time[i];
        }

        // 5. Return the maximum time
        for(int i=0;i<n;i++){
            ans=Math.max(ans,prevTime[i]);
        }
        return ans;
    }
    public static void BFS(int [] prevTime,int [] indegree,int [] time){
        Queue<Integer> q=new LinkedList<>();
        // add all the vertex/nodes having indegree 0..
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            // remove
            int e=q.poll();
            // add neighbours
            for(int i=0;i<list.get(e).size();i++){
                // decrease the indegree of every neighbouring element by 1
                int temp=list.get(e).get(i);
                indegree[temp]-=1;
                // if indegree is 0 add that node to queue
                if(indegree[temp]==0){
                    q.add(temp);
                }
                // calculate the time for current node by adding prevtime and time of parent node
                int t=prevTime[e]+time[e];
                prevTime[temp]=Math.max(prevTime[temp],t);  // take the maximum one..
            }
        }
        return;
    }
}