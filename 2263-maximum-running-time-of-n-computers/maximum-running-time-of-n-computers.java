class Solution {
    public long maxRunTime(int n, int[] batteries) {
        return maximumTime(n,batteries);
    }
    public static long maximumTime(int n,int [] nums){
        long sum=0;
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            min=Math.min(min,i);
            sum+=(long)i;
        }
        long lo=(long)min;
        long hi=sum;
        long ans=-1;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossible(mid,n,nums)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
    public static boolean isPossible(long k,int n,int [] nums){
        long target=(long)k*n;
        long curSum=0;
        for(int i=0;i<nums.length;i++){
            curSum+=Math.min((long)nums[i],k);
            if(curSum>=target){
                return true;
            }
        }
        return false;
    }
}