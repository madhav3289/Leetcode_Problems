class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int [] a,int [] b){
                if(a[1]==b[1]){
                    return a[0]-b[0];
                }
                return b[1]-a[1];
            }
        });
        for(int key:freq.keySet()){
            pq.offer(new int[]{key,freq.get(key)});
        }
        int [] ans=new int[k];
        int idx=0;
        while(!pq.isEmpty() && k-->0){
            ans[idx]=pq.poll()[0];
            idx++;
        }
        return ans;
    }
}