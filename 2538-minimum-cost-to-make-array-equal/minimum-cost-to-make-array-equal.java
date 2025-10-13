class Solution {
    public long minCost(int[] nums, int[] cost) {
        int lo=0;
        int hi=0;
        for(int i:nums){
            lo=Math.min(lo,i);
            hi=Math.max(hi,i);
        }
        long ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            long mid_c1=calculateCost(nums,cost,mid);
            long mid_c2=calculateCost(nums,cost,mid+1);
            ans=Math.min(mid_c1,mid_c2);
            if(mid_c1<mid_c2){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static long calculateCost(int [] nums,int [] cost,int mid){
        long total=0;
        for(int i=0;i<nums.length;i++){
            int val=Math.abs(nums[i]-mid);
            total+=(long)cost[i]*val;
        }
        return total;
    }
}