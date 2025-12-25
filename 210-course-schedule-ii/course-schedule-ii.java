class Solution {
    static List<List<Integer>> list;
    public int[] findOrder(int n, int[][] adj) {
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<adj.length;i++){
            int a=adj[i][0];
            int b=adj[i][1];
            list.get(b).add(a);
        }
        int [] indeg=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<list.get(i).size();j++){
                int e=list.get(i).get(j);
                indeg[e]+=1;
            }
        }
        List<Integer> res=BFS(n,indeg);
        return res.stream().mapToInt(i -> i).toArray(); 
    }
    public static List<Integer> BFS(int n,int [] indeg){
        List<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            // remove
            int e=q.poll();
            // self work
            res.add(e);
            // add neighbours
            for(int i=0;i<list.get(e).size();i++){
                int temp=list.get(e).get(i);
                indeg[temp]-=1;
                if(indeg[temp]==0){
                    q.offer(temp);
                }
            }   
        }
        return (res.size()==n)?res:new ArrayList<>();
    }
}