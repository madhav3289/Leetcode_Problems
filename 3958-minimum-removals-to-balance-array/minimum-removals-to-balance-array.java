class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int minSwaps=Integer.MAX_VALUE;
        int lo=0,hi=0;
        while(hi<n){
            while(lo<hi && (long)nums[lo]*k<nums[hi]){
                lo++;
            }
            if((long)nums[lo]*k>=nums[hi]){
                minSwaps=Math.min(minSwaps,n-(hi-lo+1));
            }
            hi++;
        }
        return minSwaps;
    }
}