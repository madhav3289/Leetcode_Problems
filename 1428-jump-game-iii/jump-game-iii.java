class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean [] visited=new boolean[n];
        visited[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int idx=q.poll();
            if(arr[idx]==0){
                return true;
            }
            int left=idx-arr[idx];
            int right=idx+arr[idx];
            if(left>=0 && !visited[left]){
                visited[left]=true;
                q.offer(left);
            }
            if(right<n && !visited[right]){
                visited[right]=true;
                q.offer(right);
            }
        }
        return false;
    }
}
