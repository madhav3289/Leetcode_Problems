class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;

        // create the prefix sum array
        long [] prefix=new long[n];
        prefix[0]=(long)nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+(long)nums[i];
        }

        long max=Long.MIN_VALUE;

        // we only need to check it form 0 to k after that repetition will start
        for(int i=0;i<k;i++){

            int lo=i;
            long curSum=Long.MIN_VALUE;

            while(lo+k-1<n){
                int hi=lo+k-1;
                long sum=prefix[hi]-(lo>0?prefix[lo-1]:0L);  // sum of current subarray os size k
                // choose whether to start a new subarray or add in existing one
                if(curSum==Long.MIN_VALUE){
                    curSum=sum;
                }
                else{
                    curSum=Math.max(sum,curSum+sum);
                }                
                max=Math.max(max,curSum);
                lo+=k;  // move to next subarray 
            }
        }
        return max;
    }
}