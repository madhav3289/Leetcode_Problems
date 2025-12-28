class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        // initialise count to 1
        int count=1;
        // check if the first subarray of size k is consecutive and sorted?
        int lo=0,hi=1;
        while(hi<k){
            if(nums[hi]==nums[hi-1]+1) count++;
            else count=1;
            hi++;
        }
        int [] res=new int[n-k+1];
        Arrays.fill(res,-1);
        if(count>=k) res[0]=nums[hi-1];
        while(hi<n){
            if(nums[hi]==nums[hi-1]+1) count++;
            else count=1;
            lo++;hi++;
            if(count>=k) res[lo]=nums[hi-1];
        }
        return res;
    }
}