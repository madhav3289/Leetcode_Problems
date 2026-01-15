class Solution {
    public long maximumScore(int[] nums, String s) {
        int n=nums.length;
        long maxScore=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
            if(s.charAt(i)=='1'){
                maxScore+=pq.poll();
            }
        }
        return maxScore;
    }
}