class Solution {
    static List<List<Integer>> list;
    public boolean canFinish(int n, int[][] adj) {
        list=new ArrayList<>();
        // create adjacency list
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<adj.length;i++){
            int a=adj[i][0];
            int b=adj[i][1];
            list.get(b).add(a);
        }
        // calculate the indegree of every element
        int [] inDegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<list.get(i).size();j++){
                int e=list.get(i).get(j);
                inDegree[e]+=1;
            }
        }
        // topological search
        return BFS(inDegree,n);
    }
    public static boolean BFS(int [] inDegree,int n){
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        // first add all elements with indegree 0
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                count++;
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int e=q.poll();
            
            for(int i=0;i<list.get(e).size();i++){
                int temp=list.get(e).get(i);
                // decrease indegree of all neighbours by 1 and 
                inDegree[temp]-=1;
                // push those to queue which have indegree 0.
                if(inDegree[temp]==0){
                    count++;
                    q.offer(temp);
                }
            }
        }
        return (count==n);
    }
}