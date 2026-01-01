class Solution {
    static List<List<Integer>> list;
    static int n;
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        list=new ArrayList<>();
        n=watchedVideos.size();
        // create adjacency list
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<friends[i].length;j++){
                list.get(i).add(friends[i][j]);
            }
        }
        // bfs to find the levels of every vertex from source node
        int [] vtxLevel=BFS(n,id);
        // store the count of every video name in freq map..
        HashMap<String,Integer> freq=new HashMap<>();
        for(int i=0;i<n;i++){
            if(vtxLevel[i]==level){
                for(int j=0;j<watchedVideos.get(i).size();j++){
                    String t=watchedVideos.get(i).get(j);
                    freq.put(t,freq.getOrDefault(t,0)+1);
                }
            }
        }
        // return the result sort by freq.
        List<String> res=new ArrayList<>(freq.keySet());
        Collections.sort(res,(a,b)->{
            if(freq.get(a)==freq.get(b)){
                return a.compareTo(b);
            }
            return freq.get(a)-freq.get(b);
        });
        return res;
    }
    public static int[] BFS(int n,int src){
        // to keep a track of levels from source node
        int [] vtxLevel=new int[n];
        Arrays.fill(vtxLevel,-1);
        vtxLevel[src]=0;    // mark the src node as level 0
        // to keep a track of visited elements
        boolean [] visited=new boolean[n];
        visited[src]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);     // add the source node to queue
        while(!q.isEmpty()){
            // remove the element from queue
            int e=q.poll();
            // add neighbouring elements of current element
            for(int i=0;i<list.get(e).size();i++){
                int nbrs=list.get(e).get(i);
                if(!visited[nbrs]){
                    // mark visited
                    visited[nbrs]=true;
                    q.add(nbrs);
                    vtxLevel[nbrs]=vtxLevel[e]+1;
                }
            }
        }
        return vtxLevel;
    }
}