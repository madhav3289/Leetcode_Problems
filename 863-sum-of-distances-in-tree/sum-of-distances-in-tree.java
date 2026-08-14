class Solution {

    // Method 2 >> Optimal (Using DP) >> O(n)

    List<List<Integer>> list=new ArrayList<>();

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        dRoot=0;
        N=n;
        count=new int[N];
        result=new int[N];

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        DFS_Root(0,-1,0);

        result[0]=dRoot;
        
        DFS(0,-1);

        return result;
    }

    public void DFS(int node,int prev){
        for(int nbrs:list.get(node)){
            if(nbrs!=prev){
                result[nbrs]=result[node]-count[nbrs]+(N-count[nbrs]);
                DFS(nbrs,node);
            }
        }
    }

    int dRoot;
    int N;
    int [] count;
    int [] result;

    public int DFS_Root(int node,int prev,int depth){
        int tNode=1;

        dRoot+=depth;

        for(int nbrs:list.get(node)){
            if(nbrs!=prev){
                tNode+=DFS_Root(nbrs,node,depth+1);
            }
        }

        count[node]=tNode;
        return tNode;
    }

    // Method 1 >> Brute Force (BFS) >> O(n^2)

    // public int[] sumOfDistancesInTree(int n, int[][] edges) {
    //     for(int i=0;i<n;i++){
    //         list.add(new ArrayList<>());
    //     }
    //     for(int [] edge:edges){
    //         list.get(edge[0]).add(edge[1]);
    //         list.get(edge[1]).add(edge[0]);
    //     }

    //     int [] result=new int[n];
    //     for(int i=0;i<n;i++){
    //         result[i]=BFS(i,n);
    //     }
    //     return result;
    // }

    // BFS 
    // public int BFS(int st,int n){
    //     Queue<int[]> q=new LinkedList<>();
    //     q.add(new int[]{st,0});

    //     int total=0;

    //     boolean [] visited=new boolean[n];
    //     visited[st]=true;

    //     while(!q.isEmpty()){

    //         int [] temp=q.poll();
    //         int u=temp[0];
    //         int v=temp[1];

    //         total=total+v;

    //         for(int nbrs:list.get(u)){
    //             if(!visited[nbrs]){
    //                 visited[nbrs]=true;
    //                 q.add(new int[]{nbrs,v+1});
                    
    //             }
    //         }
    //     }
    //     return total;
    // }
    
    // List<List<Integer>> list=new ArrayList<>();
}