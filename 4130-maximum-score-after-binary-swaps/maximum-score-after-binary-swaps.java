class Solution {
    public long maximumScore(int[] nums, String s) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                list.add(i);
            }
        }
        if(list.size()==0){
            return 0;
        }
        long maxScore=0;
        int index=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
            if(i==list.get(index)){
                maxScore+=pq.poll();
                index++;
            }
            if(index==list.size()){
                break;
            }
        }
        return maxScore;
    }
}