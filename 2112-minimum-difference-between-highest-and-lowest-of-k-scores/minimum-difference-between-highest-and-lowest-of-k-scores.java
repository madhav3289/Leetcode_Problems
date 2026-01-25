class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int lo=0,hi=0;
        int min=Integer.MAX_VALUE;
        while(hi<n){
            if(hi-lo+1>k){
                lo++;
            }
            if(hi-lo+1==k){
                min=Math.min(min,nums[hi]-nums[lo]);
            }
            hi++;
        }
        return min;
    }
}