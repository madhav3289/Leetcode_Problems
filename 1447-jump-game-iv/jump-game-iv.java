class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else{
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }
        }
        boolean [] visited=new boolean[n];
        visited[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        int steps=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int idx=q.poll();
                if(idx==n-1){
                    return steps;
                }
                int left=idx-1;
                int right=idx+1;
                if(left>=0 && !visited[left]){
                    visited[left]=true;
                    q.offer(left);
                }
                if(right<n && !visited[right]){
                    visited[right]=true;
                    q.offer(right);
                }
                if(map.containsKey(arr[idx])){
                    for(int key:map.get(arr[idx])){
                        if(!visited[key]){
                            visited[idx]=true;
                            q.offer(key);
                        }
                    }
                    map.remove(arr[idx]);
                }
            }
            steps++;
        }
        return steps;
    }
}