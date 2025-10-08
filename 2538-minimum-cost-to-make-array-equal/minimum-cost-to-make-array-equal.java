class Solution {
    public long minCost(int[] nums, int[] cost) {
        int hi=0;
        int lo=999999;
        for(int i:nums){
            hi=Math.max(hi,i);
            lo=Math.min(lo,i);
        }
        long ans=Long.MAX_VALUE;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            long val=findTotalCost(nums,cost,mid);
            long val2=findTotalCost(nums,cost,mid+1);
            if(val<val2){
                ans=val;
                hi=mid-1;
            }
            else{
                ans=Math.min(ans,val2);
                lo=mid+1;
            }
        }
        return ans;
    }
    public static long findTotalCost(int [] nums,int [] cost,int val){
        long count=0;
        for(int i=0;i<nums.length;i++){
            int n=Math.abs(val-nums[i]);
            long c=(long)n*cost[i];
            count+=c;
        }
        return count;
    }
}