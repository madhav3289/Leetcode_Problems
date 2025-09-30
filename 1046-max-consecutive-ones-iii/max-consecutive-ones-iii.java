class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int lo=0,hi=0;
        while(hi<nums.length){
            if(nums[hi]==0){
                k--;
                while(k<0){
                    if(nums[lo]==0){
                        k++;
                    }
                    lo++;
                }
            }
            max=Math.max(max,hi-lo+1);
            hi++;
        }
        return max;
    }
}