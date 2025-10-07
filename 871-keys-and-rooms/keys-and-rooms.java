class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer> q=new LinkedList<>();
        boolean [] visited=new boolean[n];
        q.offer(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int ele=q.poll();
            for(int key:rooms.get(ele)){
                if(!visited[key]){
                    q.offer(key);
                    visited[key]=true;
                }
            }            
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}