class Solution {
    static List<List<Integer>> graph;
    static int n;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n=edges.length;
        graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(edges[i]==-1){
                continue;
            }
            graph.get(i).add(edges[i]);
        }
        int [] n1=BFS(node1);
        int [] n2=BFS(node2);
        int minIdx=-1;
        int minVal=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(n1[i]==Integer.MAX_VALUE || n2[i]==Integer.MAX_VALUE){
                continue;
            }
            int val=Math.max(n1[i],n2[i]);
            if(val<minVal){
                minVal=val;
                minIdx=i;
            }
        }
        return minIdx;

    }
    public static int[] BFS(int node){
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[node]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int e=q.poll();
            for(int i:graph.get(e)){
                if(dist[e]+1<dist[i]){
                    dist[i]=dist[e]+1;
                    q.add(i);
                }
            }
        }
        return dist;
    }
}