class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int key=arr[i];
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(i);
        }

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});

        // to keep a track of visited indices
        boolean [] visited=new boolean[n];
        visited[0]=true;

        while(!q.isEmpty()){
            // remove
            int [] p=q.poll();
            int idx=p[0];
            int steps=p[1];

            // if reached the last index
            if(idx==n-1){
                return steps;
            }

            // jump 1 step back (i-1)
            if(idx>0 && !visited[idx-1]){
                visited[idx-1]=true;
                q.add(new int[]{idx-1,steps+1});
            }

            // jump 1 step forward (i+1)
            if(idx<n-1 && !visited[idx+1]){
                visited[idx+1]=true;
                q.add(new int[]{idx+1,steps+1});
            }

            // jump to indices with same value
            for(int key:map.get(arr[idx])){
                if(!visited[key]){
                    visited[key]=true;
                    q.add(new int[]{key,steps+1});
                }
            }
            map.get(arr[idx]).clear();
        }
        return -1;
    }
}