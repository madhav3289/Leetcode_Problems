class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIdx=-1;
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target){
                lo=mid+1;
            }
            else if(nums[mid]>=target){
                if(nums[mid]==target){
                    firstIdx=mid;
                }
                hi=mid-1;
            }
        }
        int lastIdx=-1;
        lo=0;
        hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<=target){
                if(nums[mid]==target){
                    lastIdx=mid;
                }
                lo=mid+1;
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }
        }
        return new int[]{firstIdx,lastIdx};
    }
}