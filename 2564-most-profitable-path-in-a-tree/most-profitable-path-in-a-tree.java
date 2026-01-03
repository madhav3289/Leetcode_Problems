class Solution {
    static List<List<Integer>> list;
    static HashMap<Integer,Integer> bobTime;
    static int aliceInc;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        list=new ArrayList<>();
        bobTime=new HashMap<>();
        aliceInc=Integer.MIN_VALUE;
        // create adjacency list
        int n=amount.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        // keep a track of visited elements for bob..
        boolean [] visited=new boolean[n];
        DFSbob(bob,visited,0);
        // keep a track of visited nodes for alice..
        visited=new boolean[n];
        DFSalice(0,0,visited,0,amount);

        return aliceInc;
    }

    public static void DFSalice(int curr,int time,boolean [] visited,int curIncome,int [] amount){
        // mark visited
        visited[curr]=true;

        if(!bobTime.containsKey(curr) || time<bobTime.get(curr)){
            curIncome+=amount[curr];
        }
        else if(time==bobTime.get(curr)){
            curIncome+=amount[curr]/2;
        }

        if(list.get(curr).size()==1 && curr!=0){
            aliceInc=Math.max(aliceInc,curIncome);
            return;
        }

        for(int nbrs:list.get(curr)){
            if(!visited[nbrs]){
                DFSalice(nbrs,time+1,visited,curIncome,amount);
            }
        }
    }

    public static boolean DFSbob(int curr,boolean [] visited,int time){
        // mark visited
        visited[curr]=true;
        bobTime.put(curr,time);
        // self-work(reached node 0)
        if(curr==0){
            return true;
        }
        // add neighbours
        for(int nbrs:list.get(curr)){
            if(!visited[nbrs]){
                if(DFSbob(nbrs,visited,time+1)){
                    return true;
                }
            }
        }
        bobTime.remove(curr);   // backtrack
        return false;   // invalid path
    }
}