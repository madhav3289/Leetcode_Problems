class Solution {
    static List<List<Integer>> list;
    static int n;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n=edges.length;
        list=new ArrayList<>();
        // creating adjacency matrix
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            // if the value of that edges is -1 means it it not connect to any vertex
            if(edges[i]==-1){
                continue;
            }
            list.get(i).add(edges[i]);
        }
        // pass node1 and compute distace of all other nodes from node1
        int [] arr1=BFS(node1,n);
        // pass node2 and compute distace of all other nodes from node2
        int [] arr2=BFS(node2,n);
        // 
        int resIdx=-1;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            // if any of the value is int maximum,
            // then from either of the two nodes that vertex is unreachable so we continue..
            if(arr1[i]==Integer.MAX_VALUE || arr2[i]==Integer.MAX_VALUE){
                continue;
            }
            int dist=Math.max(arr1[i],arr2[i]);
            if(dist<mini){
                mini=dist;
                resIdx=i;
            }
        }
        return resIdx;
    }
    public static int [] BFS(int node,int n){
        int [] dist=new int[n];
        // initialise with integer maximum value
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[node]=0;   // distance from node to self is 0
        Queue<Integer> q=new LinkedList<>();
        // add the src node
        q.add(node);
        while(!q.isEmpty()){
            // remove
            int e=q.poll();
            // ignore
            // mark visited
            // self-work
            // add neighbours
            for(int i:list.get(e)){
                if(dist[i]>dist[e]+1){
                    dist[i]=dist[e]+1;
                    q.add(i);
                }
            }
        }
        return dist;
    }
}