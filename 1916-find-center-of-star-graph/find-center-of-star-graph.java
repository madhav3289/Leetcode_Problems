class Solution {
    static int n;
    static List<List<Integer>> list;
    public int findCenter(int[][] edges) {
        n=edges.length+1;
        list=new ArrayList<>();
        int [] indegree=new int[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[0]-1).add(edge[1]-1);
            list.get(edge[1]-1).add(edge[0]-1);
            indegree[edge[0]-1]++;
            indegree[edge[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}