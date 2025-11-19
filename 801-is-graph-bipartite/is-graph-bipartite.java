class Solution {
    static class Pair{
        int vtx;
        int dist;
        public Pair(int vtx,int dist){
            this.vtx=vtx;
            this.dist=dist;
        }
    }
    public boolean isBipartite(int[][] graph) {
        Queue<Pair> q=new LinkedList<>();
        HashMap<Integer,Integer> visited=new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new Pair(i,0));
            while(!q.isEmpty()){
                Pair val=q.poll();
                if(visited.containsKey(val.vtx)){
                    if(visited.get(val.vtx)!=val.dist){
                        return false;
                    }
                    continue;
                }
                visited.put(val.vtx,val.dist);

                for(int nbr:graph[val.vtx]){
                    if(!visited.containsKey(nbr)){
                        q.add(new Pair(nbr,val.dist+1));
                    }
                }
            }
        }
        return true;
    }
}