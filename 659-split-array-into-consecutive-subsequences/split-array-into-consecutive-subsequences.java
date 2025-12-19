class Solution {
    static class Pair{
        int st;
        int ed;
        int len;
        Pair(int st,int ed){
            this.st=st;
            this.ed=ed;
            len=ed-st+1;
        }
    }
    public boolean isPossible(int[] nums) {
        int n=nums.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.ed==b.ed){
                    return a.len-b.len;
                }
                return a.ed-b.ed;
            }
        });
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek().ed+1<nums[i]){
                if(pq.poll().len<3){
                    return false;
                }
            }
            if(pq.isEmpty() || pq.peek().ed==nums[i]){
                pq.add(new Pair(nums[i],nums[i]));
            }
            else if(pq.peek().ed+1==nums[i]){
                pq.add(new Pair(pq.poll().st,nums[i]));
            }
        }
        while(!pq.isEmpty()){
            if(pq.poll().len<3){
                return false;
            }
        }
        return true;
    }
}