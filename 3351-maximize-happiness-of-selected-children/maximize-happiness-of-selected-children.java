class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        long sum=0;
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        int count=0;
        while(!pq.isEmpty() && k>0){
            int val=pq.poll();
            if(count<=val){
                sum+=val-count;
            }            
            count++;
            k--;
        }
        return sum;
    }
}